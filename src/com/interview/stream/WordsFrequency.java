package com.interview.stream;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class WordsFrequency {

    public static void main(String[] args) {

        String str = "hello hello my beautiful world world world";

        String[] words = str.split(" ");

        // key = word, value = frequency

        TreeMap<String, Val> map = new TreeMap<String, Val>();
        for(String s: words) {
            if(!map.containsKey(s)) {
                Val val= new Val();
                val.setFrequency(1);
                map.put(s, val);
            } else {
                Val val = map.get(s);
                Integer count = val.getFrequency();
                count = count+1;
                val.setFrequency(count);
            }
        }

        Comparator comparator = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Integer freq1 = map.get(o1).getFrequency();
                Integer freq2 = map.get(o2).getFrequency();
                if (freq1 > freq2) {
                    return 1;
                } else if (freq1 < freq2) {
                    return -1;
                }
                return 0;
            }
        };

        TreeMap<String, Val> mapSorted = new TreeMap<String, Val>(comparator);
        mapSorted.putAll(map);

        for(Map.Entry entry: mapSorted.entrySet()) {
            System.out.println("Word = " + entry.getKey() + " Frequency = " + ((Val)entry.getValue()).getFrequency());
        }


    }
}

class Val {
    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    private  Integer frequency;
}
