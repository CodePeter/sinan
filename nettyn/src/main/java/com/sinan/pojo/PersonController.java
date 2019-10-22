package com.sinan.pojo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersonController {

//    public PersonDTO getPersonDTO(PersonDTO personDTO, Integer age) {
    public PersonDTO getPersonDTO(PersonDTO personDTO) {
        personDTO.setAge(99);
        return personDTO;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException, InvocationTargetException, JsonProcessingException {
        Class<?> clazz = PersonController.class;
//        clazz.getDeclaredMethods()
//                for (Method method : clazz.getDeclaredMethods()) {
//                    System.out.println(method.getName());
//                }
//        Method getPersonDTO = clazz.getDeclaredMethod("getPersonDTO", new Class<?>[] {PersonDTO.class, Integer.class});
        Method getPersonDTO = clazz.getDeclaredMethod("getPersonDTO", new Class<?>[] {PersonDTO.class});
        Class<?>[] parameterTypes = getPersonDTO.getParameterTypes();
//        for (Class<?> clz : parameterTypes) {
//            System.out.println(clz.getName());
//            System.out.println(clz.getTypeName());
//        }
        Class<?> param1 = parameterTypes[0];
        Map<String, Object> params = new HashMap<>();
        params.put("name", "xiaoming");
        params.put("age", 18);
        params.put("personDTOList", new ArrayList<PersonDTO>(0));
        Object object1 = param1.newInstance();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            entry.getKey();
            entry.getValue();
            Field field = param1.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(object1, entry.getValue());
        }
//        Class<?> param2 = parameterTypes[1];
//        Object object2 = param2.newInstance();
//        for (Map.Entry<String, Object> entry : params.entrySet()) {
//            entry.getKey();
//            entry.getValue();
//            Field field = param2.getDeclaredField(entry.getKey());
//            field.setAccessible(true);
//            field.set(object2, 20);
//        }
        PersonDTO dto = (PersonDTO)getPersonDTO.invoke(clazz.newInstance(), object1);
        System.out.println(dto.getName());
        System.out.println(dto.getAge());
        System.out.println(dto.getBirthDay());
        System.out.println(JSON.toJSONString(dto));
        System.out.println(JSON.toJSONString(getPersonDTO.invoke(clazz.newInstance(), object1)));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(getPersonDTO.invoke(clazz.newInstance(), object1)));
    }
}
