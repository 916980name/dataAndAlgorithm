package com.example.algorithm;

import static com.example.algorithm.MergeSort.print;

public class BSearch {

    public static int search(int[] A, int begin, int end, int target) {
        do {
            int half = begin + ((end - begin) >>> 1);
            print("A[" + half + "]: " + A[half]);
            if (A[half] == target) {
                return half;
            }
            if (A[half] < target) {
                begin = half;
            } else {
                end = half;
            }
        } while (begin < end);
        return -1;
    }
}
