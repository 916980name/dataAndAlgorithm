package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Number137 {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
             Integer integer = map.getOrDefault(i, 0);
            if(integer == 2)
                map.remove(i);
            else map.put(i, integer + 1);
        }

        return map.keySet().iterator().next();
    }

    public static int singleNumber2(int[] nums) {
        Set<Integer> as = new HashSet<>(nums.length / 2);
        Set<Integer> bs = new HashSet<>(nums.length / 2);
        for(int i : nums) {
            if(!as.contains(i)) {
                as.add(i);
            } else if(!bs.contains(i)) {
                bs.add(i);
            } else {
                as.remove(i);
                bs.remove(i);
            }
        }
        return as.iterator().next();
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
        System.out.println(singleNumber2(arr));
    }
}
