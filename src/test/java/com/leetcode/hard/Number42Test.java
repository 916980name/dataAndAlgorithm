package com.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Number42Test {

    @Test
    void t1() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Assertions.assertEquals(6, new Number42().trap(height));
    }
}
