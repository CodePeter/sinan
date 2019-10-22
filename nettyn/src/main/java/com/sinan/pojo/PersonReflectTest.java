package com.sinan.pojo;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class PersonReflectTest {
    public static void main(String[] args) {

        Method[] methods = PersonDTO.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("---------------------------------");
            System.out.println(method.getName());
            System.out.println("TypeVariable<Method>");
            for (TypeVariable<Method> typeVariable : method.getTypeParameters()) {

                System.out.println(typeVariable.getName());
            }
            System.out.println("Class<?>");
            for (Class<?> klass : method.getParameterTypes()) {

                System.out.println(klass.getName());
            }
            System.out.println("====================================");
        }

//        TypeVariable<Class<PersonReflectTest>>[] t = PersonReflectTest.class.getTypeParameters();
//        for(TypeVariable<Class<PersonReflectTest>> m : t) {
//            /**
//             * 获得类型变量在声明的时候的名称，此例中为T
//             */
//            System.out.println(m.getName());
//            /**
//             * 获得类型变量的上边界，若无显式的定义（extends）,默认为Object;类型变量的上边界可能不止一个，
//             * 因为可以用&符号限定多个（这其中有且只能有一个为类或抽象类，且必须放在extends后的第一个，
//             * 即若有多个上边界，则第一个&后必须为接口）
//             *
//             */
//            Type[] bounds = m.getBounds();
//            for(Type t1 : bounds) {
//                System.out.println(t1);
//            }
//            /**
//             * 获得声明这个类型变量的类型及名称
//             * 类中：class reflect.ConstructorTest
//             */
//            System.out.println(m.getGenericDeclaration());
//        }
    }

    public static <T> T convertParam(Class<T> type) {
//        type.getg
//        for (Method method : type.getDeclaredMethods()) {
//            method.setAccessible(true);
//            method.
//        }
        return null;
    }
}
