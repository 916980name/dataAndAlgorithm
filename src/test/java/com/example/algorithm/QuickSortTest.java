package com.example.algorithm;

import org.junit.jupiter.api.Test;

import static com.example.algorithm.MergeSort.printArray;

public class QuickSortTest {

    @Test
    void sort() {
        int[] origin = new int[]{6, 5, 2, 9, 1, 8, 4, 3, 7};
//        int[] origin = new int[]{1,5,6,2,3,4};
        QuickSort.quick_sort(origin, origin.length);
        printArray(origin);
    }


}
