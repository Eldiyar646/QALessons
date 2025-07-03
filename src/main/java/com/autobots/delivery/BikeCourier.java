package com.autobots.delivery;

public class BikeCourier extends Person implements Deliverable {


    public BikeCourier(String name) {
        super(name);
    }

    @Override
    public void deliver() {
        status = Status.DELIVERING;
        System.out.println(name + " delivering on a bike!");

    }

    @Override
    public void introduce() {
        System.out.println("Hello, my name is " + name + " . I'm a courier on a bike.");

    }
}
