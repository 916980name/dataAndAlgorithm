package com.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Number10Test {
    static Stream<Arguments> resourceTrue() {
        return Stream.of(
                Arguments.of("aa", "a*"),
                Arguments.of("a", "ab*"),
                Arguments.of("ab", ".*.."),
                Arguments.of("ab", ".*..c*"),
                Arguments.of("ab", ".*..c*"),
                Arguments.of("ab", ".*.c*b"),
                Arguments.of("abbbcd", "ab*bbbcd")
        );
    }

    @ParameterizedTest
    @MethodSource("resourceTrue")
    void t1(String s, String reg) {
        Assertions.assertTrue(new Number10().isMatch(s, reg));
    }

    static Stream<Arguments> resourceFalse() {
        return Stream.of(
                Arguments.of("a", "aa")
        );
    }

    @ParameterizedTest
    @MethodSource("resourceFalse")
    void t2(String s, String reg) {
        Assertions.assertFalse(new Number10().isMatch(s, reg));
    }

    @Test
    void t3() {
        Assertions.assertTrue(new Number10().isMatch("aab", "c*a*b"));
    }

    @Test
    void t4() {
        Assertions.assertFalse(new Number10().isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    void t5() {
        Assertions.assertFalse(new Number10().isMatch("aaa", "ab*a"));
    }

    @Test
    void t6() {
        Assertions.assertFalse(new Number10().isMatch("aaba", "ab*a*c*a"));
    }

    @Test
    void t7() {
        long b = System.currentTimeMillis();
        boolean res = new Number10().isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c");
        long e = System.currentTimeMillis();
        System.out.println("time: " + (e - b));
        Assertions.assertFalse(res);
    }
}
