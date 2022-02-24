package com.example.algorithm;

import org.junit.jupiter.api.Test;

class BSearchTest {
    @Test
    void test1() {
        int[] A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(BSearch.search(A, 0, A.length, 10));
    }

    @Test
    void test2() {
        int[] A = new int[]{1, 2, 4, 4, 4, 4, 4, 8, 9, 10};
        System.out.println(BSearch.searchLastOneMatch(A, 0, A.length, 4));
    }

    @Test
    void test3() {
        int[] A = new int[]{1, 2, 2, 2, 2, 2, 4, 8, 9, 10};
        System.out.println(BSearch.searchLastOneMatch(A, 0, A.length, 4));
    }

    @Test
    void test4() {
//        int[] A = new int[]{3, 5, 6, 8, 9, 10};
        int[] A = new int[]{1, 2, 2, 2, 2, 2, 4, 8, 9, 10};
        System.out.println(BSearch.searchFirstOneGreaterThan(A, 0, A.length, 7));
    }

    @Test
    void test5() {
        int[] A = new int[]{3, 5, 6, 8, 9, 10};
//        int[] A = new int[]{1, 2, 2, 2, 2, 2, 4, 8, 9, 10};
        System.out.println(BSearch.searchLastOneLessThan(A, 0, A.length, 7));
    }
}
