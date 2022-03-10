package com.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Number44Test {
    static Stream<Arguments> resourceTrue() {
        return Stream.of(
                Arguments.of("aa", "*"),
                Arguments.of("aa", "?*"),
                Arguments.of("aa", "a*")
        );
    }

    @ParameterizedTest
    @MethodSource("resourceTrue")
    void t1(String s, String reg) {
        Assertions.assertTrue(new Number44().isMatch(s, reg));
    }

    static Stream<Arguments> resourceFalse() {
        return Stream.of(
                Arguments.of("a", "aa"),
                Arguments.of("a", "ab*"),
                Arguments.of("ab", "?*??"),
                Arguments.of("ab", "?*?*?"),
                Arguments.of("ab", "?*??**"),
                Arguments.of("ab", "*?*??c*"),
                Arguments.of("ab", "?*??c*"),
                Arguments.of("ab", "?*?c*b"),
                Arguments.of("ab", "?*??c*"),
                Arguments.of("ab", "?*??c*"),
                Arguments.of("ab", "?*?c*b"),
                Arguments.of("abbbcd", "ab*bbbcd")
        );
    }

    @ParameterizedTest
    @MethodSource("resourceFalse")
    void t2(String s, String reg) {
        Assertions.assertFalse(new Number44().isMatch(s, reg));
    }

    @Test
    void t3() {
        Assertions.assertFalse(new Number44().isMatch("aab", "c*a*b"));
    }

    @Test
    void t4() {
        Assertions.assertTrue(new Number44().isMatch("mississippi", "mis*is*p*?"));
    }

    @Test
    void t5() {
        Assertions.assertFalse(new Number44().isMatch("aaa", "ab*a"));
    }

    @Test
    void t6() {
        Assertions.assertFalse(new Number44().isMatch("aaba", "ab*a*c*a"));
    }

    @Test
    void t7() {
        long b = System.currentTimeMillis();
        boolean res = new Number44().isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c");
        long e = System.currentTimeMillis();
        System.out.println("time: " + (e - b));
        Assertions.assertFalse(res);
    }

    @Test
    void t8() {
        Assertions.assertTrue(new Number44().isMatch("ab", "?*"));
    }

    @Test
    void t9() {
        Assertions.assertTrue(new Number44().isMatch("adceb", "*c*b"));
    }

    @Test
    void t10() {
        Assertions.assertFalse(new Number44().isMatch("acdcb", "a*c?b"));
    }

    @Test
    void t11() {
        Assertions.assertTrue(new Number44().isMatch("abcabczzzde", "*abc???de*"));
    }

    @Test
    void t12() {
        Assertions.assertTrue(new Number44().isMatch("c", "****?*"));
    }

    @Test
    void t13() {
        Assertions.assertTrue(new Number44().isMatch("ab", "*ab"));
    }

    @Test
    void t14() {
        Assertions.assertFalse(new Number44().isMatch("", "ab*"));
    }

}
