package com.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Number407Test {
    @Test
    void t1() {
        int[][] heightMap = new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        Assertions.assertEquals(4, new Number407().trapRainWater(heightMap));
    }

    @Test
    void t2() {
        int[][] heightMap = new int[][]{{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};
        Assertions.assertEquals(10, new Number407().trapRainWater(heightMap));
    }

    @Test
    void t3() {
        int[][] heightMap = new int[][]{{12,13,1,12}
                                       ,{13,4,13,12}
                                       ,{13,8,10,12}
                                       ,{12,13,12,12}
                                       ,{13,13,13,13}};
        Assertions.assertEquals(14, new Number407().trapRainWater(heightMap));
    }

    @Test
    void t4() {
        int[][] heightMap = new int[][]{{1,4,3,1,3,2},
                                        {3,2,1,3,2,4},
                                        {2,3,3,2,3,1}};
        Assertions.assertEquals(4, new Number407().trapRainWater(heightMap));
    }
}
