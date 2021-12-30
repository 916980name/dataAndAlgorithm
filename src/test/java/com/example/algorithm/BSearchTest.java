package com.example.algorithm;

import org.junit.jupiter.api.Test;

class BSearchTest {
    @Test
    void test1() {
        int[] A = new int[]{1, 2, 3, 4, 5, 6, 7,  8, 9, 10};
        System.out.println(BSearch.search(A, 0, A.length, 10));
    }
}
