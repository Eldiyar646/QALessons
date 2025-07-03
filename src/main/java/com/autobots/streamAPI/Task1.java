package com.autobots.streamAPI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {

        List<String> names = List.of("Anna", "Bob", "Alex", "Bella", "Andrew");
        //превращает данный список с именами, в которых имена начинаются с нижнего регистра
        List<String> nameLower = names.stream().map(String::toLowerCase).toList();
        System.out.println(nameLower);

        //здесь перебираем список с именами и распечатываем все имена начинающиеся на букву А.
        //перебираем список используя цикл
        List<String> nameWithA = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("A"))
                nameWithA.add(name.toUpperCase());
            Collections.sort(nameWithA);
        }
        System.out.println(nameWithA);

        //тут тот же самый перебор имен, только используя потоки(СТРИМ)
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);

        //обычный способ суммировать числа в листе.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int r1 = 0;
        for (int num : numbers) {
            r1 += num;
        }
        System.out.println(r1);

        //способ суммирования используя СТРИМ
        int totalSum = numbers.stream()
                .mapToInt(num -> num)
                .sum();
        System.out.println(totalSum);

        //здесь с помощью СТРИМ считаем сколько элементов в листе
        int totalElements = (int) numbers.stream().count();
        System.out.println(totalElements);

        //здесь с помощью СТРИМ находим минимальное число в листе
        numbers.stream()
                .min(Integer::compareTo)
                .ifPresent(System.out::println);

        //  Оператор :: в Java называется method reference — это сокращённая форма записи лямбда-выражений,
        //  когда ты просто передаёшь существующий метод как функцию.

        List<String> list = List.of("one", "two", "three", "Hello","four", "five");
        //тут находим строку, длина которой, больше трех символов и которая стоит первая в списке.
        list.stream()
                .filter(s -> s.length()>3)
                .findFirst()
                .ifPresent(System.out::println);

        //using flatmap, превращает вложенный лист в единый лист.
        List<List<String>> nestedList = List.of(
                List.of("A", "B"),
                List.of("C", "D"),
                List.of("E"));
        System.out.println(nestedList);

        List<String> listNest = nestedList.stream().flatMap(Collection::stream).toList();
        System.out.println(listNest);

    }
}
