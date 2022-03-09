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

}
