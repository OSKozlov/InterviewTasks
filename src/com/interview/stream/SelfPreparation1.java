package com.interview.stream;

// Дан список чисел: [1, 2, 3, 4, 5, 6].

// Отфильтруй чётные числа.
// Умножь каждое число на 2.
// Собери результат в новый список.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelfPreparation1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> newList = list.stream()
                .filter(num -> num%2 == 0 )
                .map(num -> num*2)
                .collect(Collectors.toList());
        newList.forEach(System.out::println);
    }
}
