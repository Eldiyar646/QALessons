package com.autobots.delivery;

public class WalkCourier extends Person implements Deliverable {


    public WalkCourier(String name) {
        super(name);
    }

    public void deliver() {
        status = Status.DELIVERING;
        System.out.println(name + " walk delivering!");

    }

    @Override
    public void introduce() {
        System.out.println("Hello, my name is " + name + " . I'm a walking courier.");

    }
}
