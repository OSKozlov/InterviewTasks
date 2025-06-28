package com.interview.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SelfPreparation3 {

    static class Person {
        String name;
        int age;
        String city;

        public Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public String getCity() { return city; }

        @Override
        public String toString() { return name + " (" + age + ", " + city + ")"; }
    }

/*    Сгруппируй людей по городу (city).
    Для каждого города создай список имён людей (name), живущих в этом городе.
    Результат должен быть Map<String, List<String>>, где ключ — город, а значение — список имён.*/
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "Moscow"),
                new Person("Bob", 30, "Moscow"),
                new Person("Charlie", 20, "Berlin"),
                new Person("David", 35, "Moscow"),
                new Person("Eve", 28, "Berlin")
        );

        Map<String, List<String>> result = people.stream()
                .collect(Collectors.groupingBy(Person::getCity,
                        Collectors.mapping(Person::getName, Collectors.toList())));
        result.entrySet().forEach(entry ->
                System.out.println("City: " + entry.getKey() + " persons: " + entry.getValue()));


//        Найди средний возраст людей в каждом городе.
//                Результат должен быть Map<String, Double>, где ключ — город, а значение — средний возраст жителей.
//                Если в городе нет людей (хотя в данном случае это не так), средний возраст должен быть 0.0.
        people = Arrays.asList(
                new Person("Alice", 25, "Moscow"),
                new Person("Bob", 30, "Moscow"),
                new Person("Charlie", 20, "Berlin"),
                new Person("David", 35, "Moscow"),
                new Person("Eve", 28, "Berlin")
        );

        Map<String, Double> rez = people.stream()
                .collect(Collectors.groupingBy(Person::getCity,
                        Collectors.averagingDouble(Person::getAge)));
        rez.computeIfAbsent("Empty", k->0.0);
        rez.entrySet().forEach(entry -> System.out.println("Key = " + entry.getKey() + " avg age = " + entry.getValue()));
    }
}
