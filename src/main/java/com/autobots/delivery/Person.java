package com.autobots.delivery;

public abstract class Person {

    String name;
    Status status;

    public Person(String name) {
        this.name = name;
        this.status = Status.AVAILABLE;
    }

    public void showStatus() {
        System.out.println(name + " - " + status);
    }

    public abstract void introduce();
}
