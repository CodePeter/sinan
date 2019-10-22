package com.sinan.apache.commons3.lang;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,String> supportType = new HashMap<>();
        supportType.put(".jpg", ".jpg");
        supportType.put(".gifs", ".gifs");
//        supportType.put(".jpg", ".jpg");
        supportType.get(".jpg");
        System.out.println(supportType.get(".jpg"));
        System.out.println(supportType.get(".jpg1"));
        System.out.println(supportType.get(""));
        System.out.println(supportType.get(null));
    }
}
