package com.sinan.util;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringArray2IntTest {
    public static void main(String[] args) {
        String a = "a1,2,3,4,5";
//        Arrays.stream(a.split(",")).collect(Arrays::new);
//        Integer[] ss = Stream.of(a).toArray(Integer[]::new);
//        System.out.println(ss);
        int[] x = Arrays.stream(a.split(",")).mapToInt(Integer::valueOf).toArray();
        Arrays.stream(x).forEach(n -> System.out.println(n));
        System.out.println(x);
    }
}
