package com.interview.stream;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SelfPreparation4 {

    static class Order {
        String customer;
        List<Integer> items; // цены товаров в заказе

        public Order(String customer, List<Integer> items) {
            this.customer = customer;
            this.items = items;
        }

        public String getCustomer() { return customer; }
        public List<Integer> getItems() { return items; }
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Alice", Arrays.asList(100, 200, 300)),
                new Order("Bob", Arrays.asList(150, 250)),
                new Order("Alice", Arrays.asList(400))
        );

//        Задание:

//        Найди общую сумму всех товаров (items) для каждого клиента.
//                Результат должен быть Map<String, Integer>, где ключ — имя клиента, а значение — сумма цен всех его товаров.
//                Пример результата: { "Alice": 1000, "Bob": 400 } (100 + 200 + 300 + 400 = 1000 для Alice, 150 + 250 = 400 для Bob).


        Map<String, Integer> result = orders.stream()
                .flatMap(order -> order.getItems().stream()
                        .map(price-> new AbstractMap.SimpleEntry<>(order.getCustomer(), price)))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.summingInt(Map.Entry::getValue)));
        result.entrySet().forEach(entry ->
                System.out.println(" key = " + entry.getKey() + " value = " + entry.getValue()));

//        Найди клиентов, у которых есть хотя бы один товар дороже 200.
//        Для каждого такого клиента верни список цен товаров, которые дороже 200.
//        Результат: Map<String, List<Integer>>, например, { "Alice": [300, 400], "Bob": [250] }.

        Map<String, List<Integer>> resultMap = orders.stream()
                .flatMap(order -> order.getItems().stream()
                        .filter(price -> price > 200)
                        .map(price -> new AbstractMap.SimpleEntry<>(order.getCustomer(), price)))
                        .collect(Collectors.groupingBy(Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        resultMap.entrySet()
                .forEach(entry -> System.out.println("key: " + entry.getKey() + "value: " + entry.getValue()));

    }
}
