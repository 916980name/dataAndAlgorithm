package com.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Number1007Test {
    @Test
    void t1() {
        int[] tops = new int[]{2,1,2,4,2,2};
        int[] bottoms = new int[]{5,2,6,2,3,2};
        Assertions.assertEquals(2, new Number1007().minDominoRotations(tops, bottoms));
    }

    @Test
    void t2() {
        int[] tops = new int[]{3,5,1,2,3};
        int[] bottoms = new int[]{3,6,3,3,4};
        Assertions.assertEquals(-1, new Number1007().minDominoRotations(tops, bottoms));
    }

    @Test
    void t3() {
        int[] tops = new int[]{1,2,1,1,1,2,2,2};
        int[] bott = new int[]{2,1,2,2,2,2,2,2};
        Assertions.assertEquals(1, new Number1007().minDominoRotations(tops, bott));
    }
}
