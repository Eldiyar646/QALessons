package com.autobots.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryMain {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        List<Person> couriers = new ArrayList<>();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Add courier");
            System.out.println("2. Show all couriers");
            System.out.println("3. Start delivery");
            System.out.println("0. Exit");
            System.out.println("Choose action: ");
            int choice = scn.nextInt();
            scn.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter courier name: ");
                    String name = scn.next();

                    System.out.println("Type: 1. On a bike, 2. On a car, 3. Walk");
                    int type = scn.nextInt();
                    scn.nextLine();

                    if (type == 1) {
                        couriers.add(new BikeCourier(name));
                    } else if (type == 2) {
                        couriers.add(new CarCourier(name));
                    } else if (type == 3) {
                        couriers.add(new WalkCourier(name));
                    } else {
                        System.out.println("Invalid choice. Exit.");
                    }
                }

                case 2 -> {
                    if (couriers.isEmpty()) {
                        System.out.println("No couriers");
                    } else {
                        for (int i = 0; i < couriers.size(); i++) {
                            System.out.println(i + ". ");
                            couriers.get(i).introduce();
                            couriers.get(i).showStatus();
                        }
                    }
                }

                case 3 -> {
                    if (couriers.isEmpty()) {
                        System.out.println("No free couriers");
                        break;
                    }

                    System.out.println("Choose courier: ");
                    for (int i = 0; i < couriers.size(); i++) {
                        System.out.println(i + " - " + couriers.get(i).name);
                    }

                    int id = scn.nextInt();
                    scn.nextLine();

                    if (id >= 0 && id < couriers.size()) {
                        Person p = couriers.get(id);
                        if (p.status == Status.AVAILABLE) {
                            ((Deliverable) p).deliver();
                        } else {
                            System.out.println("Courier is busy.");
                        }
                    } else {
                        System.out.println("Invalid index.");
                    }
                }

                case 0 -> {
                    System.out.println("Exit from program.");
                    scn.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");

            }

        }
    }
}
