package com.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Number228Test {
    private List<String> summaryRanges(int[] nums) {
//        return Number228.summaryRanges(nums);
        return Number228.summaryRanges2(nums);
    }
    @Test
    void t1() {
        int[] nums = new int[]{0,1,2,4,5,7};
        List<String> res = summaryRanges(nums);
        Assertions.assertEquals("0->2", res.get(0));
        Assertions.assertEquals("4->5", res.get(1));
        Assertions.assertEquals("7", res.get(2));
    }

    @Test
    void t2() {
        int[] nums = new int[]{0,2,3,4,6,8,9};
        List<String> res = summaryRanges(nums);
        Assertions.assertEquals("0", res.get(0));
        Assertions.assertEquals("2->4", res.get(1));
        Assertions.assertEquals("6", res.get(2));
        Assertions.assertEquals("8->9", res.get(3));
    }

    @Test
    void t3() {
        int[] nums = new int[]{};
        List<String> res = summaryRanges(nums);
        Assertions.assertEquals(0, res.size());
    }
}
