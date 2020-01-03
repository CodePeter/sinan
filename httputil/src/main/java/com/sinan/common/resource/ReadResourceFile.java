package com.sinan.common.resource;

import java.io.*;
import java.net.URL;

public class ReadResourceFile {
    public static void main(String[] args) throws IOException {
//        URL url = ReadResourceFile.class.getResource("hello.txt");
//        System.out.println(url.toString());
//        System.out.println(ReadResourceFile.class.getResource("hello.txt"));
        System.out.println(ReadResourceFile.class.getResource(""));
//        URL base = ReadResourceFile.class.getResource("");
//        URL base = ReadResourceFile.class.getClassLoader().getResource("com/sinan/common/resource/hello.txt");
        URL base = ReadResourceFile.class.getClassLoader().getResource("tmp/hello.txt");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(base.openStream());
        InputStreamReader reader = new InputStreamReader(base.openStream());
        BufferedReader bufferedReader = new BufferedReader(reader);
        System.out.println(bufferedReader.readLine());
//        File file = new File(base.getFile(), "com/sinan/common/resource/hello.txt");
//        if (file.exists() && file.isFile()) {
//
//                    System.out.println(file.getName());
//        }
//        String path = file.getPath();
//        System.out.println(path);
    }
}
