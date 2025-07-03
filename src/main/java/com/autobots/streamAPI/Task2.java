package com.autobots.streamAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {

        List<String> verbs = List.of("eating", "read", "rinning", "talking", "play");
        List<String> verb = verbs.stream()
                .filter(v -> v.endsWith("ing"))
                .map(String::toUpperCase).toList();
        System.out.println(verb);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(sum);

        List<String> names = List.of("Anna", "Artem", "Bob", "Bill", "Charlie", "Clara");

        Map<Character, List<String>> charName = names.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

        System.out.println("Names by alphabet:");

        charName.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println
                            (entry.getKey() + ": " + String.join(", ", entry.getValue()));
                });
    }
}