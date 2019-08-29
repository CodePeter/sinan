package com.sinan.scan;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class ScanPackage {

    private Set<Class<?>> classes;
    private String packageName;

    public void init() {
        this.classes = new LinkedHashSet<Class<?>>();
        this.packageName = "org.apache.logging.log4j";
        parsePackageName();
//        travleClassFiles();
    }

    public void parsePackageName() {
        String packageDirName = packageName.replace('.', '/');
        // 定义一个枚举的集合 并进行循环来处理这个目录下的things
        try {
            Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(
                    packageDirName);
            while (dirs.hasMoreElements()) {
                // 获取下一个元素
                URL url = dirs.nextElement();
                // 得到协议的名称
                String protocol = url.getProtocol();
                // 如果是以文件的形式保存在服务器上
//                if ("file".equals(protocol)) {
//                    // 获取包的物理路径
//                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
//                    System.out.println(filePath);
//                    if (filePath.startsWith("/")) {
//                        filePath = filePath.substring(1);
//                    }
//                    File rootFile = new File(filePath);
//                    travleClassFiles(rootFile, packageName);
//                }
//                else if("jar".equals(protocol)) {
//                    travleJarFiles(url, packageDirName);
//                }
                if ("jar".equals(protocol)) {
                    travleJarFiles(url, packageDirName);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void travleClassFiles(File dirFile, String packageName) {
        File[] fileList = dirFile.listFiles();
        for (File file : fileList) {
            if (file.isDirectory()) {
                String fileName = file.getName();
                travleClassFiles(file, packageName + "." + fileName);
            } else {
                String fileName = file.getName();
                if (fileName.endsWith(".class")) {
                    try {
                        System.out.println(packageName + "." + fileName.substring(0, fileName.length() - 6));
                        classes.add(Class.forName(packageName + "." + fileName.substring(0, fileName.length() - 6)));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void travleJarFiles(URL url, String packageDirName) {
        // 如果是jar包文件
        // 定义一个JarFile
        JarFile jar = null;
        // 获取jar
        try {
            jar = ((JarURLConnection) url.openConnection()).getJarFile();
        } catch (Exception e) {

        }
        // 从此jar包 得到一个枚举类
        Enumeration<JarEntry> entries = jar.entries();
        // 同样的进行循环迭代
        while (entries.hasMoreElements()) {
            // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
            JarEntry entry = entries.nextElement();
            String name = entry.getName();
            if (name.contains("KafkaManager")) {
                System.out.println(name);
            }
            System.out.println(name);
            // 如果是以/开头的
            if (name.charAt(0) == '/') {
                // 获取后面的字符串
                name = name.substring(1);
            }
            // 如果前半部分和定义的包名相同
            if (name.startsWith(packageDirName)) {
                int idx = name.lastIndexOf('/');
                // 如果以"/"结尾 是一个包
                if (idx != -1) {
                    // 获取包名 把"/"替换成"."
                    packageName = name.substring(0, idx).replace('/', '.');
                }
                // 如果可以迭代下去 并且是一个包
//                    if ((idx != -1) || true) {
                // 如果是一个.class文件 而且不是目录
                if (name.endsWith(".class") && !entry.isDirectory()) {
                    // 去掉后面的".class" 获取真正的类名
                    String className = name.substring(packageName.length() + 1, name.length() - 6);
                    if (className.contains("KafkaManager")) {
                        System.out.println(className);
                    }
                    // 添加到classes
                    Class<?> clazz = null;
                    try {
                        clazz = Class.forName(packageName + '.' + className);
                        classes.add(clazz);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }


    }

    public Set<Class<?>> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class<?>> classes) {
        this.classes = classes;
    }

    public static void main(String[] args) {
        ScanPackage scanPackage = new ScanPackage();
        scanPackage.init();
        Set<Class<?>> classes = scanPackage.getClasses();
        System.out.println(classes);
    }
}
