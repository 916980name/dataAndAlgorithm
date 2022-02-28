package com.leetcode.medium;

import com.leetcode.medium.Number165;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Number165Test {
    static Stream<Arguments> resourceEqual() {
        return Stream.of(
                Arguments.of("1.01", "1.001"),
                Arguments.of("1.0", "1.0.0")
        );
    }

    @ParameterizedTest
    @MethodSource("resourceEqual")
    void t1(String version1, String version2) {
        int res = Number165.compareVersion(version1, version2);
        Assertions.assertEquals(0, res);
    }

    @Test
    void t2() {
        String version1 = "2.105", version2 = "2.22";
        int res = Number165.compareVersion(version1, version2);
        Assertions.assertEquals(1, res);
    }

    @Test
    void t3() {
        String version1 = "0.1", version2 = "1.0";
        int res = Number165.compareVersion(version1, version2);
        Assertions.assertEquals(-1, res);
    }
}
