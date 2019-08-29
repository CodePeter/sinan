package com.sinan.scan;

public class ClassForNameTest {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            try {

                Class.forName("com.lalala.test");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
