package com.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        System.out.println("### max length = " + longestSubstr("abcabcabcdefghijklmabc"));
    }

    private static int longestSubstr(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) +1, left);
            }

            map.put(currentChar, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
