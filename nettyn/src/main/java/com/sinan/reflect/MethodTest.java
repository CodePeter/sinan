package com.sinan.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        Class<?> clazz = Class.forName("com.sinan.reflect.ElectricCar");
        Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("com.sinan.reflect.ElectricCar");
        System.out.println(clazz.getName());
        System.out.println(clazz.getInterfaces().length);
        System.out.println(clazz.getDeclaredMethods().length);
//        Method method = clazz.getMethod("drive");
//        method.invoke(clazz.newInstance());
//        Arrays.stream(clazz.getd()).forEach(clzz -> {
//            clzz.getCanonicalName();
//            System.out.println(clzz.getCanonicalName());
//        });
        Arrays.stream(clazz.getDeclaredMethods()).forEach(
                method -> {
                    try {
                        List<Object> params = new ArrayList<>();
                        Arrays.stream(method.getParameterTypes()).forEach(param -> {
                            try {
                                params.add(param.newInstance());
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        });
                        method.invoke(clazz.newInstance(), params.toArray());
//                        method.invoke(clazz.newInstance(), params);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
