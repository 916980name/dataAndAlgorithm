package com.example.algorithm;

import static com.example.algorithm.MergeSort.print;

public class BSearch {
    private static int gethalf(int begin, int end) {
        return begin + ((end - begin) >>> 1);
    }

    public static int search(int[] A, int begin, int end, int target) {
        do {
            int half = gethalf(begin, end);
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

    public static int searchLastOneMatch(int[] A, int begin, int end, int target) {
        int low = begin;
        int high = end - 1;
        while(low < high) {
            int half = gethalf(low, high);
            print("A[" + half + "]: " + A[half]);
            if(A[half] <= target) {
                low = half + 1;
            } else {
                high = half - 1;
            }
        }
        if(low < end && A[low] == target) {
            return low;
        }
        return -1;
    }

    public static int searchFirstOneGreaterThan(int[] A, int begin, int end, int target) {
        int low = begin;
        int high = end - 1;
        while(low <= high) {
            int half = gethalf(low, high);
            print("low: " + low + ", high: " + high + ", A[" + half + "]: " + A[half]);
            if(A[half] <= target) {
                low = half + 1;
            } else {
                high = half - 1;
            }
        }
        if(low < end && A[low] > target) {
            return low;
        }
        return -1;
    }

    public static int searchLastOneLessThan(int[] A, int begin, int end, int target) {
        int low = begin;
        int high = end - 1;
        while(low <= high) {
            int half = gethalf(low, high);
            print("low: " + low + ", high: " + high + ", A[" + half + "]: " + A[half]);
            if(A[half] < target) {
                low = half + 1;
            } else {
                high = half - 1;
            }
        }
        if(low < end && A[high] < target) {
            return high;
        }
        return -1;
    }
}
