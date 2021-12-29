package com.example.algorithm;

public class MergeSort {

    // 归并排序算法, A是数组，n表示数组大小
    public static void merge_sort(int[] A, int n) {
        merge_sort_c(A, 0, n - 1);
    }

    // 递归调用函数
    static void merge_sort_c(int[] A, int p, int r) {
        print("[merge_sort_c] " + stringfyArray(A) + ", p: " + p + ", r: " + r);
        // 递归终止条件
        if (p >= r) {
            return;
        }
        // 取p到r之间的中间位置q
        int q = (p + r) / 2;
        // 分治递归
        merge_sort_c(A, p, q);
        merge_sort_c(A, q + 1, r);
        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(A, p, q, r);
    }

    static void merge(int[] A, int p, int q, int r) {
        print("[merge] " + stringfyArray(A) + ", p: " + p + ", q: " + q + ", r: " + r);
        int[] tmp = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;
        while (i <= q && j <= r) {
            print("A[" + i + "] <= A[" + j + "]: " + A[i] + ", " + A[j]);
            if (A[i] <= A[j]) {
                tmp[k++] = A[i++];
            } else {
                tmp[k++] = A[j++];
            }
            print("tmp: " + stringfyArray(tmp));
        }

        print("i < q: " + i + ", " + q);
        if (i < q + 1) {
            copyXToTarget(tmp, A, k, i, q + 1);
        } else {
            copyXToTarget(tmp, A, k, j, r + 1);
        }

        copyXToTarget(A, tmp, p, 0, tmp.length);
    }

    public static void copyXToTarget(int[] target, int[] origin, int targetBegin, int originBegin, int originEnd) {
        print("origin: " + stringfyArray(origin) + ", begin: " + originBegin + ", end:" + originEnd);
        print("target: " + stringfyArray(target) + ", begin: " + targetBegin);
        int i = targetBegin, j = originBegin;
        while (j < originEnd) {
            target[i++] = origin[j++];
        }
        print("copyXToTarget: " + stringfyArray(target));
        print("------------");
    }

    public static void printArray(int[] a) {
        System.out.println(stringfyArray(a));
    }

    public static String stringfyArray(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i + ", ");
        }
        return sb.toString();
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
