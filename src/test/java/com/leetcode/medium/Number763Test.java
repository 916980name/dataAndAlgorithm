package com.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class Number763Test {
    static Number763 solution;

    @BeforeAll
    static void init() {
        solution = new Number763();
    }

    @Test
    void t1() {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = solution.partitionLabels(s);
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(9, result.get(0));
        Assertions.assertEquals(7, result.get(1));
        Assertions.assertEquals(8, result.get(2));
    }

    @Test
    void t2() {
        String s = "a";
        List<Integer> result = solution.partitionLabels(s);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(1, result.get(0));
    }
}
