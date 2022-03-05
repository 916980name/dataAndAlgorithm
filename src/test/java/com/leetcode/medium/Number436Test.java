package com.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Number436Test {
    @Test
    void t1() {
        int[] res = Number436.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}});
        Assertions.assertEquals(-1, res[0]);
        Assertions.assertEquals(0, res[1]);
        Assertions.assertEquals(1, res[2]);
    }

    @Test
    void t2() {
        int[] res = Number436.findRightInterval(new int[][]{{4, 5}, {2, 3}, {1, 2}});
        Assertions.assertEquals(-1, res[0]);
        Assertions.assertEquals(0, res[1]);
        Assertions.assertEquals(1, res[2]);
    }

    @Test
    void t3() {
        int[] res = Number436.findRightInterval(new int[][]{{1,12},{2,9},{3,10},{13,14},{15,16},{16,17}});
        Assertions.assertEquals(3, res[0]);
        Assertions.assertEquals(3, res[1]);
        Assertions.assertEquals(3, res[2]);
        Assertions.assertEquals(4, res[3]);
        Assertions.assertEquals(5, res[4]);
        Assertions.assertEquals(-1, res[5]);
    }
}
