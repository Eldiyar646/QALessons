package com.autobots.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {

        //получаем число длины строк
        List<String> fruits = List.of("apple", "banana", "cherry");
        List<Integer> length = fruits.stream().map(String::length).toList();
        System.out.println(length);

        //отфильтровать четные числа и отсортировать
        List<Integer> numbers = List.of(5,2,8,1,3);
        List<Integer> even = numbers.stream().filter(num->num % 2 == 0).sorted().collect(Collectors.toList());
        System.out.println(even);

        //преобразовать список строк в один список символов
        List<String> list1 = List.of("ab", "cd", "ef");
        List<String> list2 = list1.stream().flatMap(s -> Arrays.stream(s.split(""))).toList();
        System.out.println(list2);

        //группировка по первой букве и красивый вывод на консоль
        List<String> fruit = List.of("apple", "apricot", "banana", "blueberry", "cherry");
        Map<Character, List<String>> grouped = fruit.stream().collect(Collectors.groupingBy(s->s.charAt(0)));
        System.out.println("Fruits by alphabet: ");

        grouped.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
            System.out.println(entry.getKey() + ": " + String.join(", " , entry.getValue()));
        });






    }
}
