package com.example.algorithm;

import static com.example.algorithm.MergeSort.print;
import static com.example.algorithm.MergeSort.printArray;
import static com.example.algorithm.MergeSort.stringfyArray;

public class QuickSort {

    // 快速排序，A是数组，n表示数组的大小
    public static void quick_sort(int[] A, int n) {
        printArray(A);
        quick_sort_c(A, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    static void quick_sort_c(int[] A, int p, int r) {
        print("[quick_sort_c] A: " + stringfyArray(A) + ", p: " + p + ", r: " + r);
        if (p >= r) {
            return;
        }

        int q = partition(A, p, r); // 获取分区点
        quick_sort_c(A, p, q - 1);
        quick_sort_c(A, q + 1, r);
    }


    static int partition(int[] A, int p, int r) {
        int pivot = A[r];
        int i = p;
        for(int j = p; j < r; j++) {
            print("A[" + j + "] < pivot: " + A[j] + ", " + pivot);
            if(A[j] < pivot) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, i, r);
        print("partition: " + i);
        return i;
    }

    static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
        print("swap A[" + i + "], A[" + j + "]: " + A[i] + ", " + A[j] + " ... " + stringfyArray(A));
    }
}
