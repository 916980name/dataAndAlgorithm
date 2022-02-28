package com.leetcode.hard;

public class Number4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int end = (nums1.length + nums2.length) / 2;
        boolean isEven = (nums1.length + nums2.length) % 2 == 0;
        boolean evenFlag = isEven;
        if(isEven) end--;
        int sum = 0;
        int i = 0, j = 0;
        for(int k = 0; k <= end; k++) {
            System.out.println("i: " + i + ", j: " + j + ", k: " + k);
            if(nums2.length == 0 || j >= nums2.length || (i < nums1.length && nums1[i] <= nums2[j])) {
                if(k >= end) {
                    System.out.println("sum: " + sum + ", i: " + i + ", num1: " + nums1[i]);
                    sum += nums1[i++];
                    if(isEven) {
                        end++;
                        isEven = false;
                        continue;
                    }
                    break;
                }
                i++;
            } else {
                if(k >= end) {
                    System.out.println("sum: " + sum + ", j: " + j + ", num2: " + nums2[j]);
                    sum += nums2[j++];
                    if(isEven) {
                        end++;
                        isEven = false;
                        continue;
                    }
                    break;
                }
                j++;
            }
        }
        return evenFlag? (double) sum / 2 : sum;
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,2}, nums2 = new int[]{3, 4};
//        int[] nums1 = new int[]{2}, nums2 = new int[]{};
        int[] nums1 = new int[]{100001}, nums2 = new int[]{100000};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
