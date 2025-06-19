package com.interview.algo;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 8, 10, 15, 18, 22};
        int target = 15;
        int result = binarySearch(arr, target);
        System.out.println("Элемент " + target + " находится на индексе: " + result);
    }
}
