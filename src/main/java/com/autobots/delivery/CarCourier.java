package com.autobots.delivery;

public class CarCourier extends Person implements Deliverable {


    public CarCourier(String name) {
        super(name);
    }

    public void deliver() {
        status = Status.DELIVERING;
        System.out.println(name + " delivering on a car!");

    }

    @Override
    public void introduce() {
        System.out.println("Hello, my name is " + name + " . I'm a courier on a car.");

    }

}
