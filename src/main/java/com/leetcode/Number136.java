package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Number136 {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            if(map.containsKey(i))
                map.remove(i);
            else map.put(i, 1);
        }

        Set<Integer> integers = map.keySet();
        int key = 0;
        for(Integer i : integers) {
            key = i;
        }
        return key;
    }

    public static int singleNumber2(int[] nums) {
        boolean[] bitmap = new boolean[3 * (10 * 10 * 10 * 10) * 2];
        for(int i : nums) {
            if(i < 0) {
                i = -i;
            } else {
                i = i + 30000;
            }
            bitmap[i] = !bitmap[i];
        }
        for(int j = 0; j < bitmap.length; j++) {
            if (bitmap[j]) {
                if (j < 30000) {
                    return -j;
                } else {
                    return j - 30000;
                }
            }
        }
        return 0;
    }

    public static int singleNumber3(int[] nums) {
        boolean[] bitmap = new boolean[nums.length / 2 + 1];
        int[] indexToNumber = new int[nums.length / 2 + 1];
        for(int i : nums) {
            if(i < 0) {
                i = -(i / 2 + 1);
            } else {
                i = i + 30000;
            }
            bitmap[i] = !bitmap[i];
        }
        for(int j = 0; j < bitmap.length; j++) {
            if (bitmap[j]) {
                if (j < 30000) {
                    return -j;
                } else {
                    return j - 30000;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
        System.out.println(singleNumber2(arr));
        System.out.println(singleNumber3(arr));
    }
}
