package com.interview.algo;

import java.util.*;

public class DublicateDemo {

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 9, 9, 12, 1};
        int result = findDublicate(arr);
        System.out.println("result  = " + result);
    }

    private static int findDublicate(int[] arr) {
        Set<Integer> unique = new HashSet<>();
        for(Integer num : arr) {
            if (!unique.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
