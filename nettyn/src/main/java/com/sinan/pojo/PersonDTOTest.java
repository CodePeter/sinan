package com.sinan.pojo;


import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


public class PersonDTOTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.sinan.pojo.PersonDTO");
//            System.out.println(clazz.getTypeName());
//            System.out.println(clazz.getFields().length);
//            System.out.println(clazz.getDeclaredFields().length);
//            Arrays.stream(clazz.getDeclaredFields()).forEach(field -> {
//
//                System.out.println("Field Name: "+field.getName());
//                System.out.println(field.getType().getName());
//                System.out.println(field.getType().getTypeName());
//                System.out.println(field.getType().getTypeParameters());
//                System.out.println(field.getClass().getName());
//            });
//            Arrays.stream(clazz.getFields()).forEach(field -> {
//                field.set("name");
//            });
            Map<Object, Object> fieldMap = new HashMap<>();
            Map<String, Object> params = new HashMap<>();
            params.put("name", "xiaoming");
            params.put("age", 18);
            Object object = clazz.newInstance();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                entry.getKey();
                entry.getValue();
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                Type type = field.getGenericType();
                field.set(object, entry.getValue());
            }
            System.out.println(clazz.cast(object));
            System.out.println(((PersonDTO)object).getAge());
            System.out.println(((PersonDTO)object).getName());
            System.out.println(((PersonDTO)object).getBirthDay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
