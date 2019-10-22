package com.sinan.reflect;

public class ElectricCar implements Rechargable, Vehicle {

    @Override
    public void drive() {
        System.out.println("Electric Car is Moving silently...");
    }

    @Override
    public void recharge(String message) {
        System.out.println("Electric Car is Recharging...");
    }

}