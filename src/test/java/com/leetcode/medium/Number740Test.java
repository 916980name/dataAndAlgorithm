package com.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Number740Test {
    @Test
    void t1() {
        Number740 n = new Number740();
        int[] nums = new int[]{2,2,3,3,3,4};
        Assertions.assertEquals(9, n.deleteAndEarn(nums));
    }

    @Test
    void t2() {
        Number740 n = new Number740();
        int[] nums = new int[]{4,10,10,8,1,4,10,9,7,6};
        Assertions.assertEquals(53, n.deleteAndEarn(nums));
    }

    @Test
    void t3() {
        Number740 n = new Number740();
        int[] nums = new int[]{2,2,3,3,3,4};
        Assertions.assertEquals(9, n.deleteAndEarn(nums));
    }

    @Test
    void t4() {
        Number740 n = new Number740();
        int[] nums = new int[]{1};
        Assertions.assertEquals(1, n.deleteAndEarn(nums));
    }

    @Test
    void t5() {
        Number740 n = new Number740();
        int[] nums = new int[]{3, 1};
        Assertions.assertEquals(4, n.deleteAndEarn(nums));
    }

    @Test
    @Disabled
    void t6() {
        Number740 n = new Number740();
        int[] nums = new int[]{12,32,93,17,100,72,40,71,37,92,58,34,29,78,11,84,77,90,92,35,12,5,27,92,91,23,65,91,85,14,42,28,80,85,38,71,62,82,66,3,33,33,55,60,48,78,63,11,20,51,78,42,37,21,100,13,60,57,91,53,49,15,45,19,51,2,96,22,32,2,46,62,58,11,29,6,74,38,70,97,4,22,76,19,1,90,63,55,64,44,90,51,36,16,65,95,64,59,53,93};
//        Assertions.assertEquals(4, n.deleteAndEarn(nums));
        long b = System.currentTimeMillis();
        int res = n.deleteAndEarn(nums);
        long a = System.currentTimeMillis();
        System.out.println(res + ", time: " + (a - b));
    }
}
