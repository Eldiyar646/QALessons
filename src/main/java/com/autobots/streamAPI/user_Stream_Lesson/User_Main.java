package com.autobots.streamAPI.user_Stream_Lesson;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User_Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Anna", 22, "Bishkek"),
                new User("Bob", 30, "Osh"),
                new User("Charlie", 25, "Bishkek"),
                new User("David", 28, "Osh"),
                new User("Eva", 19, "Batken")
        );

        List<User> names = users.stream()
                .filter(c -> c.getCity().equals("Bishkek"))
                .collect(Collectors.toList());
        System.out.println(names);

        User maxAge = users.stream()
                .max(Comparator.comparing(User::getAge))
                .get();
        System.out.println("Максимальный возраст: " + maxAge);

        Map<String, List<User>> groupingByCity = users.stream()
                .collect(Collectors.groupingBy(User::getCity));
        groupingByCity.forEach((city, list) -> {
            System.out.println(city + " -> " + list);
        });

        Map<String, Double> avgAge = users.stream()
                .collect(Collectors.groupingBy(User::getCity, Collectors.averagingInt(User::getAge)));
        System.out.println("Average age: " + avgAge);

        boolean hasMinor = users.stream().anyMatch(user -> user.getAge() < 18);
        System.out.println(hasMinor);


    }
}
