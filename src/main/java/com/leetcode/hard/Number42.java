package com.leetcode.hard;

public class Number42 {
    class Wrap {
        public int sum = 0;
        public int lastH = 0;
        public int right = 0;

        @Override
        public String toString() {
            return "Wrap{" +
                    "sum=" + sum +
                    ", lastH=" + lastH +
                    ", right=" + right +
                    '}';
        }

        public Wrap(int sum, int lastH, int right) {
            this.sum = sum;
            this.lastH = lastH;
            this.right = right;
        }
    }

    //https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int sum = 0;

        while(left <= right) {
            if (height[left] <= height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                sum += maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                sum += maxRight - height[right];
                right--;
            }
        }
        return sum;
    }
/*    public int trap(int[] height) {
        int sum = 0;
        int lastH = 0;
        for(int i = 0; i < height.length; i++) {
            Wrap w = subTrap(height, i, lastH);
            sum += w.sum;
            lastH = w.lastH;
        }
        return sum;
    }*/

    private Wrap subTrap(int[] height, int left, int lastH) {
        System.out.println("[subTrap] l: " + left + ", lH: " + lastH);
        if(left >= height.length) return new Wrap(0, lastH, left);
        int leftH = height[left];
        int l = left + 1;
        int sum = 0;
        for(; l < height.length;) {
            if(leftH > height[l]) {
                Wrap w = subTrap(height, l, lastH);
                if(w.right >= height.length) {
                    w.sum += sum;
                    System.out.println("[return]: " + w);
                    return w;
                }
                sum += w.sum;
                System.out.println("[sum] l: " + left + ", r: " + l + ", lH: " + lastH + ", sum: " + w.sum);
                w = sum(height, left, w.right, lastH);
                sum += w.sum;
                lastH = w.lastH;
                l = w.right;
                left = l;
                leftH = height[left];
            } else if(leftH < height[l]) {
                return new Wrap(sum, lastH, l);
            } else {
                l++;
                continue;
            }
        }
        Wrap w = new Wrap(sum, lastH, height.length);
        System.out.println("[return]: " + w);
        return w;
    }

    private Wrap sum(int[] height, int left, int right, int lastH) {
        if(height[left] == 0 || height[right] == 0)
            return new Wrap(0, 0, right);
        int sum = 0;
        int h = height[left] - height[right];
        h = h < 0 ? -h : h;
        while(right - left > 1 && left++ < right) {
            sum += (h - height[left] - lastH);
        }
        return new Wrap(sum, h, right);
    }

}
