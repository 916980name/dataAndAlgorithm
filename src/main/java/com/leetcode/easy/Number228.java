package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Number228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int b = 0, e = 1;
        while(b < nums.length) {
            if(e >= nums.length || nums[e - 1] + 1 < nums[e]) {
                if(b + 1 == e) {
                    result.add(String.valueOf(nums[b]));
                } else {
                    result.add(nums[b] + "->" + nums[e - 1]);
                }
                b = e;
            }
            e++;
        }
        return result;
    }

    public static List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<>();
        StringBuilder bud = new StringBuilder();
        int b = 0, e = 1;
        while(b < nums.length) {
            if(e >= nums.length || nums[e - 1] + 1 < nums[e]) {
                if(b + 1 == e) {
                    result.add(bud.append(nums[b]).toString());
                } else {
                    result.add(bud.append(nums[b]).append("->").append(nums[e - 1]).toString());
                }
                bud.setLength(0);
                b = e;
            }
            e++;
        }
        return result;
    }
}
