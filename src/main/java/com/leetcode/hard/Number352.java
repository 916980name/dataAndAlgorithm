package com.leetcode.hard;

import java.util.LinkedList;

/**
 * int[] = {min, max}
 */
public class Number352 {
    private LinkedList<int[]> intervalList;
    public Number352 () {
        intervalList = new LinkedList<>();
    }

    public void addNum(int val) {
        if(intervalList.isEmpty()) {
            intervalList.add(new int[]{val, val});
            return;
        }
        int i;
        for(i = 0; i < intervalList.size(); i++) {
            int[] node = intervalList.get(i);
            if(val < node[0]) {
                intervalList.add(i, new int[]{val, val});
                merge(i);
                break;
            } else if(val <= node[1]) {
                return;
            } else if(i + 1 == intervalList.size()){
                intervalList.addLast(new int[]{val, val});
                merge(i);
                break;
            }
        }
    }

    private void merge(int index) {
        int[] target;
        if(index - 1 >= 0) {
            target = intervalList.get(index);
            int[] before = intervalList.get(index - 1);
            if(before[1] + 1 == target[0]) {
                before[1] = target[0];
                intervalList.remove(index--);
            }
        }

        if(index + 1 < intervalList.size()) {
            target = intervalList.get(index);
            int[] next = intervalList.get(index + 1);
            if(next[0] - 1 == target[1]) {
                next[0] = target[0];
                intervalList.remove(index);
            }
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[intervalList.size()][];
        for(int i = 0; i < intervalList.size(); i++) {
            res[i] = intervalList.get(i);
        }
        return res;
    }
}
