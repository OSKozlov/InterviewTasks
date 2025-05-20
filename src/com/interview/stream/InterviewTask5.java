package com.interview.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewTask5 {

/*    Есть 2 списка (a,b,c) і (1,2,3,4,5).
    Нужно вернуть список с максимальными комбинациями: (a1,a2,..,a5,b1,...),
    но не использовать циклы, а только стримы.*/

    public static void main(String[] args) {
        List<String> letters = Arrays.asList("a", "b", "c");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<String> result = letters.stream().flatMap(letter -> numbers.stream().
                map(num -> letter + num)).collect(Collectors.toList());
        System.out.println("result = " + result);

        List<String> strings = List.of("a", "b", "c");
        List<Integer> integers = List.of(1, 2, 3, 4, 5);

        List<Stream<String>> collectedLists = integers.stream()
                .map(o -> strings.stream()
                        .map(s -> s.concat(o.toString())))
                .toList();

        collectedLists.forEach(stringStream -> stringStream.forEach(System.out::println));
//        System.out.println("collectedLists = " + collectedLists);

    }

}
