package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Number260 {
    public static int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer i : nums) {
            if(set.contains(i))
                set.remove(i);
            else set.add(i);
        }
        int[] a = new int[set.size()];
        int i = 0;
        for(Integer s : set) {
            a[i++] = s;
        }
        return a;
    }

    private static void printArr(int[] a) {
        for(int i : a) {
            System.out.print(i + ", ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,5};
        printArr(singleNumber(arr));
    }
}
