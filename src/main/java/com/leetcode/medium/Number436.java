package com.leetcode.medium;

import java.util.Arrays;
import java.util.TreeMap;

public class Number436 {
    public static int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        return Arrays.stream(intervals)
                .map(ints -> map.getOrDefault(ints[1],
                    map.higherKey(ints[1]) != null ? map.get(map.higherKey(ints[1])) : -1
                ))
                .mapToInt(Integer::valueOf).toArray();
    }
}
