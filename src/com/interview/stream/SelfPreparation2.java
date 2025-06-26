package com.interview.stream;

//Дан список строк: ["apple", "banana", "cherry", "date", "elderberry"].
//
//Задание:
//
//        Отфильтруй строки, длина которых больше 5 символов.
//Преобразуй каждую строку в её длину (например, "apple" → 5).
//Найди сумму всех длин.

import java.util.Arrays;
import java.util.List;

public class SelfPreparation2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        Integer result = list.stream()
                .filter(str -> str.length() > 5)
                .mapToInt(String::length)
                .sum();
        System.out.println(" Result = " + result);
    }
}
