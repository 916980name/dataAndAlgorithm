package com.leetcode.medium;

import com.leetcode.utils.StringfyUtils;

public class Number1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops.length == 1) {
            if(tops[0] != bottoms[0]) return -1;
            return 0;
        }
        int[] target = new int[2];
        int[][] count = new int[2][2];
        if(tops[0] == tops[1]) {
            target[0] = tops[0];
            count[0][0] = 2;
        } else if(tops[0] == bottoms[1]) {
            target[0] = tops[0];
            count[0][0] = 1;
            count[0][1] = 1;
        }
        if(bottoms[0] == bottoms[1]) {
            target[1] = bottoms[0];
            count[1][1] = 2;
        } else if(bottoms[0] == tops[1]) {
            target[1] = bottoms[0];
            count[1][0] = 1;
            count[1][1] = 1;
        }
        if(target[0] == 0 && target[1] == 0) return -1;
        for(int i = 2; i < tops.length; i++) {
            int t = target[0];
            int b = target[1];
            if(t != 0) {
                if(t == tops[i] && t == bottoms[i])
                    continue;
                if(t == tops[i]) {
                    count[0][0]++;
                } else if(t == bottoms[i]) {
                    count[0][1]++;
                } else {
                    target[0] = 0;
                }
            }
            if(b != 0) {
                if(b == tops[i] && b == bottoms[i])
                    continue;
                if(b == tops[i]) {
                    count[1][0]++;
                } else if(b == bottoms[i]) {
                    count[1][1]++;
                } else {
                    target[1] = 0;
                }
            }
            System.out.println(StringfyUtils.stringfyInt2DArray(count));
            if(target[0] == 0 && target[1] == 0) return -1;
        }
        int res1 = Math.min(count[0][0], count[0][1]);
        int res2 = Math.min(count[1][0], count[1][1]);
        if(target[0] == 0) {
            return res2;
        } else if(target[1] == 0) {
            return res1;
        } else {
            return Math.min(res1, res2);
        }
    }
}
