package com.interview.stream;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency2 {

    public static void main(String[] args) {
        String str = "hello hello my beautiful world world world";

        String[] words = str.split(" ");

        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        frequencyMap.entrySet().stream().sorted((e1, e2) -> {
            if (e1.getValue() == e2.getValue()) return 0;
            return (e1.getValue() < e2.getValue()) ? 1 : -1;
        }).limit(10).forEachOrdered(entry -> {
            System.out.println("Key = " + entry.getKey() +
                    " frequency = " + entry.getValue());
        });
    }
}
