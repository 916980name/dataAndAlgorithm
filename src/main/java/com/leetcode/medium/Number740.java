package com.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Number740 {
    Number740() {

    }
    public int deleteAndEarn(int[] nums) {
        return new Solution1().deleteAndEarn(nums);
    }

    class Solution1 {
        private Map<Integer, Integer> cache;

        Solution1() {
            cache = new HashMap<>();
        }

        private Integer getCode(int[] nums) {
            Integer code = 0;
            for (int i = 0; i < nums.length; i++) {
                code += (nums[i] == 0 ? 0 : 1 << i);
            }
            return code;
        }

        private Integer getFromCache(int[] nums) {
            Integer code = getCode(nums);
            Integer recordMax = cache.get(code);
            if (recordMax == null) {
                System.out.println("[cache GET]: " + recordMax + ", code: " + code + ", arr: " + stringfyArr(nums));
            } else {
                System.out.println("[cache EARN]: " + recordMax + ", code: " + code + ", arr: " + stringfyArr(nums));
            }
            return recordMax;
        }

        private void putToCache(int[] nums, int max) {
            Integer code = getCode(nums);
            System.out.println("[cache put]: " + max + ", code: " + code + ", arr: " + stringfyArr(nums));
            cache.put(code, max);
        }

        public int deleteAndEarn(int[] nums) {
            return deleteAndEarn(nums, 0);
        }

        private int deleteAndEarn(int[] nums, int start) {
            int max = 0;
            for (int i = start; i < nums.length; i++) {
                if (nums[i] == 0) continue;
                Integer recordMax = getFromCache(nums);
                if (recordMax == null) {
                    max = Math.max(pickOne(Arrays.copyOf(nums, nums.length), i), max);
                } else {
                    max = recordMax;
                }
            }
            putToCache(nums, max);
            return max;
        }

        private int pickOne(int[] nums, int i) {
            int sum = 0;
            int pick = nums[i];
            nums[i] = 0;
            sum += pick;
            int r1 = pick - 1, r2 = pick + 1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == r1 || nums[j] == r2) {
                    nums[j] = 0;
                } else if (nums[j] == pick) {
                    nums[j] = 0;
                    sum += pick;
                }
            }
            System.out.println("Pick: " + pick + ", Earn: " + sum + ", arr: " + stringfyArr(nums));
            return sum + deleteAndEarn(nums, i);
        }
    }

    private String stringfyArr(int[] nums) {
        StringBuilder buf = new StringBuilder();
        for (int num : nums) {
            buf.append(num).append(",");
        }
        return buf.toString();
    }

    class Solution2 {
        /**
         *          | 0--2--------------earn max
         *  --------|-------------------------->
         *  nums[0] | T  T
         *  nums[1] |
         *  nums[2] |
         *  nums[3] |
         *  ...     |
         *          V
         */
        public int deleteAndEarn(int[] nums) {
            if(nums.length < 1) return 0;
            int max = Arrays.stream(nums).sum();
            boolean[][] records = new boolean[nums.length][max + 1];
            records[0][0] = true;
            records[0][nums[0]] = true;
            for(int i = 1; i < nums.length; i++) {
                // When not pick number in this index
                for(int j = 0; j < max; j++) {
                    if(records[i - 1][j]) {
                        records[i][j] = true;
                    }
                }
                // When pick number in this index
                for(int j = 0; j < max - nums[i]; j++) {
                    if(records[i - 1][j]) {
                        records[i][j + nums[i]] = true;
                    }
                }
            }
            // result
            for(int i = max; i >= 0; i--) {
                if(records[nums.length - 1][i]) return i;
            }
            return 0;
        }

        private int sumProcess(int[] nums, int i) {
            return -1;
        }
    }
}
