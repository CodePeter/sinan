package com.sinan.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinan.util.DateConstants;
import com.sinan.util.ThreadLocalDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PersonDTO {
    @JsonIgnore
    private int age;
    private String name;
    private Date birthDay;
    private String birthDayFormat;
    private List<PersonDTO> personDTOList;

    public PersonDTO() {
//        this.birthDayFormat = DateConstants.YYYY_MM_DD_HH_MM_SS.format(getBirthDay());
    }

    public List<PersonDTO> getPersonDTOList() {
        return personDTOList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        setBirthDayFormat(DateConstants.YYYY_MM_DD_HH_MM_SS.format(birthDay));
        this.birthDay = birthDay;
    }

    public String getBirthDayFormat() {
//        ThreadLocalDateFormat format = DateConstants.YYYY_MM_DD_HH_MM_SS;
//        System.out.println(format.format(new Date()));
//        return DateConstants.YYYY_MM_DD_HH_MM_SS.format(birthDay);
        return this.birthDayFormat;
    }

    public void setBirthDayFormat(String birthDayFormat) {
        this.birthDayFormat = birthDayFormat;
    }

    public void setPersonDTOList(List<PersonDTO> personDTOList) {
        this.personDTOList = personDTOList;
    }

    public static void main(String[] args) throws JsonProcessingException, ParseException {
//        PersonDTO personDTO = new PersonDTO();
//        personDTO.setBirthDay(new Date());
//        System.out.println(personDTO);
//        System.out.println(personDTO.getBirthDay());
//        ObjectMapper objectMapper = new ObjectMapper();
//        PersonDTO personDTO = new PersonDTO();
//        personDTO.setAge(18);
//        personDTO.setName("xiaoming");
//        personDTO.setBirthDay(new Date());
//        System.out.println(objectMapper.writeValueAsString(personDTO));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2006-09-01");
        System.out.println(startDate);
        System.out.println(startDate.getTime());
    }
}
