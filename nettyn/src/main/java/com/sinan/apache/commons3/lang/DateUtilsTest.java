package com.sinan.apache.commons3.lang;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class DateUtilsTest {
    public static void main(String[] args) {
//        try {
//            Date result1 =  DateUtils.parseDate("2019-10-10", new String[]{ "yyyy-MM-dd HH:mm:ss",  "yyyy-MM-dd"});
//            Date result2 =  DateUtils.parseDate("2019-10-10 20:30:59", new String[]{ "yyyy-MM-dd HH:mm:ss",  "yyyy-MM-dd"});
//            System.out.println(result1);
//            System.out.println(result2);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String name = "coffee.jpg";
//        String[] chips = name.split("\\.");
//        System.out.println(chips.length);
//        System.out.println(chips[chips.length-1]);
//        System.out.println(name.substring(name.lastIndexOf(".")));
//                       "----------------------------811366579993818010681771--\n";
//                            --------------------------841163863524669707486266
        String content = "----------------------------811366579993818010681771\n" +
                "Content-Disposition: form-data; name=\"appendixFile\"; filename=\"test.txt\"\n" +
                "Content-Type: text/plain\n" +
                "\n" +
                "aaa\n" +
                "bbb\n" +
                "ccc\n" +
                "ddd\n" +
                         "----------------------------811366579993818010681771--\n";
        int pos = content.indexOf("filename=\"");
        System.out.println(pos);
        System.out.print(content.substring(pos));
        pos = content.indexOf("\n", pos);
        System.out.println(pos);
        System.out.print(content.substring(pos));
        pos = content.indexOf("\n", pos);
        System.out.println(pos);
        System.out.print(content.substring(pos));
        String boundaryText = "--------------------------811366579993818010681771";
//        int boundaryLoc = content.indexOf(boundaryText, pos);
        int boundaryLoc = content.indexOf(boundaryText, pos);
        System.out.println(boundaryLoc);
        System.out.print("boundaryLoc: "+content.substring(boundaryLoc));

    }
}
