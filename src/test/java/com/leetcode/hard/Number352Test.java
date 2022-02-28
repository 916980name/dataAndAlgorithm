package com.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Number352Test {
    @Test
    void t1() {
        Number352 summaryRanges = new Number352();
        int[][] res;
        summaryRanges.addNum(1);
        res = summaryRanges.getIntervals();
        Assertions.assertEquals(1, res[0][0]);
        Assertions.assertEquals(1, res[0][1]);

        summaryRanges.addNum(3);
        res = summaryRanges.getIntervals();
        Assertions.assertEquals(1, res[0][0]);
        Assertions.assertEquals(1, res[0][1]);
        Assertions.assertEquals(3, res[1][0]);
        Assertions.assertEquals(3, res[1][1]);

        summaryRanges.addNum(7);
        res = summaryRanges.getIntervals();
        Assertions.assertEquals(1, res[0][0]);
        Assertions.assertEquals(1, res[0][1]);
        Assertions.assertEquals(3, res[1][0]);
        Assertions.assertEquals(3, res[1][1]);
        Assertions.assertEquals(7, res[2][0]);
        Assertions.assertEquals(7, res[2][1]);

        summaryRanges.addNum(2);
        res = summaryRanges.getIntervals();
        Assertions.assertEquals(1, res[0][0]);
        Assertions.assertEquals(3, res[0][1]);
        Assertions.assertEquals(7, res[1][0]);
        Assertions.assertEquals(7, res[1][1]);

        summaryRanges.addNum(6);
        res = summaryRanges.getIntervals();
        Assertions.assertEquals(1, res[0][0]);
        Assertions.assertEquals(3, res[0][1]);
        Assertions.assertEquals(6, res[1][0]);
        Assertions.assertEquals(7, res[1][1]);

        summaryRanges.addNum(8);
        res = summaryRanges.getIntervals();
        Assertions.assertEquals(1, res[0][0]);
        Assertions.assertEquals(3, res[0][1]);
        Assertions.assertEquals(6, res[1][0]);
        Assertions.assertEquals(8, res[1][1]);
    }
}
