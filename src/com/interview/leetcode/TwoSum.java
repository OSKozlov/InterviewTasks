package com.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] result = retrieveTwoSum(new int[]{2,7,11,15}, 22);
        if (result != null && result.length != 0) {
            System.out.println(result[0] + " " + result[1]);
        }
    }

    private static int[] retrieveTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<=nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return nums;
    }

}
