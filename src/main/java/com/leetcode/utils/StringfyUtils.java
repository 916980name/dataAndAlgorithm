package com.leetcode.utils;

public class StringfyUtils {
    public static StringBuilder stringfyBoolean2DArray(boolean[][] arr) {
        StringBuilder buf = new StringBuilder();
        int i = 0;
        for (boolean[] num1 : arr) {
            for(boolean num : num1) {
                buf.append(num ? 1 : 0).append(" ");
            }
            buf.append("\n");
            i++;
        }
        return buf;
    }

    public static StringBuilder stringfyInt2DArray(int[][] arr) {
        StringBuilder buf = new StringBuilder();
        int i = 0;
        for (int[] num1 : arr) {
            for(int num : num1) {
                buf.append(num).append(" ");
            }
            buf.append("\n");
            i++;
        }
        return buf;
    }

    public static StringBuilder stringfyIntArray(int[] arr) {
        StringBuilder buf = new StringBuilder();
        buf.append('[');
        for (int num1 : arr) {
            buf.append(num1).append(",");
        }
        buf.append(']');
        return buf;
    }

}
