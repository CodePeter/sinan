package com.sinan.reflect;


import com.sinan.pojo.PersonDTO;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class GenericTypeObject {

    public static <T> T getTypeObject(Class<T> targetType) {
        Object object = null;
        try {
            Map<Object, Object> fieldMap = new HashMap<>();
            Map<String, Object> params = new HashMap<>();
            params.put("name", "xiaoming");
            params.put("age", 18);
            object = targetType.newInstance();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                entry.getKey();
                entry.getValue();
                Field field = targetType.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                Type type = field.getGenericType();
                field.set(object, entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)object;
    }

    public static void main(String[] args) {
        PersonDTO personDTO = GenericTypeObject.getTypeObject(PersonDTO.class);
        System.out.println(personDTO.getAge());
        System.out.println(personDTO.getName());
        System.out.println(personDTO.getBirthDay());
    }
}
