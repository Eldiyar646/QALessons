package com.autobots.streamAPI.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeApp {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Alice", 28, 3000, "IT"),
                new Employee(2, "Bob", 35, 4000, "HR"),
                new Employee(3, "Charlie", 40, 5000, "Finance"),
                new Employee(4, "David", 25, 3500, "IT"),
                new Employee(5, "Eva", 30, 4200, "Marketing"),
                new Employee(6, "Frank", 45, 6000, "Finance"),
                new Employee(7, "Grace", 32, 4100, "HR"),
                new Employee(8, "Henry", 29, 3900, "IT"),
                new Employee(9, "Isabel", 38, 4500, "Marketing"),
                new Employee(10, "Jack", 27, 3600, "IT")
        );

        //простой вывод средней зарплаты по отделам, но так лучше не делать
        Map<String, Double> averageSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));
        System.out.println("Average salary by department: ");
        averageSalary.forEach((dep, averageSal) -> System.out.println(dep + ": $ " + averageSal));

        System.out.println("-----------------------------");

        //более сложный вариант вывода, тут вывод отформатирован, отсортирован
        averageSalary.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.printf
                            ("%s: $%.2f%n", entry.getKey() ,entry.getValue());
                });

//        List<Employee> itEmployee = employees.stream()
//                .filter(d -> d.getDepartment().equalsIgnoreCase("IT"))
//                .collect(Collectors.toList());
//        System.out.println(itEmployee);
//        System.out.println("----ForEach-----");

        //реализация вывода информации по отделам используя СТРИМ
        Map<String, List<Employee>> employeesByDepartment =employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        employeesByDepartment.forEach((department, list1)->{
            System.out.println("Отдел " + department);
            list1.forEach(System.out::println);
        });

        System.out.println("------------------------");

        //обычная реализация через цикл
        Map<String, List<Employee>> employeesByDepartment2 = new HashMap<>();
        for (Employee employee : employees){
            employeesByDepartment2.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            employeesByDepartment2.get(employee.getDepartment()).add(employee);
        }
        for (Map.Entry<String, List<Employee>> entry : employeesByDepartment2.entrySet()){
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }


    }
}
