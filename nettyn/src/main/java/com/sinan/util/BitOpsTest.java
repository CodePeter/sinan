package com.sinan.util;

public class BitOpsTest {
    public static void main(String[] args) {
        int i32 = 11111111;
        System.out.println(i32);
        System.out.println(0xff & i32);
        System.out.println(0xff & (i32 >> 8));
        System.out.println((byte) i32);
        System.out.println((byte) (0xff & i32));
    }
}
