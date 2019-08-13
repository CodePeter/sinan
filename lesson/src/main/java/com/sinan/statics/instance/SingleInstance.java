package com.sinan.statics.instance;

public class SingleInstance {

    private static final SingleInstance INSTANCE = new SingleInstance();

    private SingleInstance() {

    }

    public static SingleInstance getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        SingleInstance instance1 = SingleInstance.getInstance();
        SingleInstance instance2 = SingleInstance.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
