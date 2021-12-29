package com.example.algorithm;

import org.junit.jupiter.api.Test;

import static com.example.algorithm.MergeSort.printArray;

public class MergeSortTest {
    @Test
    void copyTest() {
        int[] target = new int[10];
        int[] origin1 = new int[]{1, 3, 5, 7, 9};
        int[] origin2 = new int[]{2, 4, 6, 8, 0};

        MergeSort.copyXToTarget(target, origin1, 0, 0, 5);
        MergeSort.copyXToTarget(target, origin2, 5, 2, 4);
        MergeSort.copyXToTarget(target, origin2, 7, 0, 2);

        printArray(target);
    }

    @Test
    void sort() {
        int[] origin = new int[]{6, 5, 2, 9, 1, 8, 4, 3, 7};
//        int[] origin = new int[]{1,5,6,2,3,4};
        MergeSort.merge_sort(origin, origin.length);
        printArray(origin);
    }


}
