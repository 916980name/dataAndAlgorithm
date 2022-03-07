package com.leetcode.medium;

import com.leetcode.excellentResolution.No740;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Number740 {
    Number740() {

    }
    public int deleteAndEarn(int[] nums) {
//        return new Solution1().deleteAndEarn(nums);
//        return new No740().deleteAndEarn(nums);
//        return new Solution2().deleteAndEarn(nums);
        return new Solution3().deleteAndEarn(nums);
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

    private String stringfyArrInteger(Integer[] nums) {
        StringBuilder buf = new StringBuilder();
        for (Integer num : nums) {
            buf.append(num).append(",");
        }
        return buf.toString();
    }

    private String stringfyArr2(Integer[] keys, boolean[][] nums) {
        StringBuilder buf = new StringBuilder();
        buf.append("    ");
        for (int i = 0; i < nums[0].length; i++) {
            buf.append(i).append(i < 10 ? "  " : " ");
        }
        buf.append("\n");
        int i = 0;
        for (boolean[] num1 : nums) {
            buf.append(keys[i]).append(":").append(keys[i] < 10 ? "  " : " ");
            for(boolean num : num1) {
                buf.append(num ? 1 : 0).append(", ");
            }
            buf.append("\n");
            i++;
        }
        return buf.toString();
    }

    class Solution2 {
        /**
         *             | 0--1--2--------------earn max
         *  -----------|-------------------------->
         *  newnums[0] | T  T
         *  newnums[1] |
         *  newnums[2] |
         *  newnums[3] |
         *  ...        |
         *             V
         */
        public int deleteAndEarn(int[] nums) {
            if(nums.length < 1) return 0;
            // {nums[i] : nums[i] * k}
            Map<Integer, Integer> getPointMap = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                getPointMap.put(nums[i], nums[i] + getPointMap.getOrDefault(nums[i], 0));
            }
            int max = Arrays.stream(nums).sum();
            // sorted, important
            Integer[] newNums = getPointMap.keySet()
                    .stream().sorted()
                    .collect(Collectors.toList())
                    .toArray(new Integer[0]);

            boolean[][] records = new boolean[newNums.length][max + 1];
            records[0][0] = true;
            records[0][getPointMap.get(newNums[0])] = true;
            for(int i = 1; i < newNums.length; i++) {
                // When not pick number in this index
                for(int j = 0; j < max; j++) {
                    if(records[i - 1][j]) {
                        records[i][j] = true;
                    }
                }
                // When pick number in this index
                for (int j = 0; j < max; j++) {
                    int jump = newNums[i] - newNums[i - 1] > 1 ? 1 : 2;
                    // line 1, can't calculate line -1, so use itself
                    if(jump == 2 && i == 1) {
                        records[1][getPointMap.get(newNums[i])] = true;
                        break;
                    }
                    if (records[i - jump][j]) {
                        records[i][j + getPointMap.get(newNums[i])] = true;
                    }
                }
            }
//            System.out.println(stringfyArrInteger(newNums));
//            System.out.println(getPointMap);
//            System.out.println(stringfyArr2(newNums, records));
            // result
            for(int i = max; i >= 0; i--) {
                if(records[newNums.length - 1][i]) return i;
            }
            return 0;
        }
    }

    /**
     * newNums[i-1]    1       4       6       7...10
     * getPointMap.get nums[0] nums[1] nums[2] ... nums[newNums.length]
     * records:     0  max1    max2    max3        result
     */
    class Solution3 {
        public int deleteAndEarn(int[] nums) {
            if(nums.length < 1) return 0;
            // {nums[i] : nums[i] * k}
            Map<Integer, Integer> getPointMap = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                getPointMap.put(nums[i], nums[i] + getPointMap.getOrDefault(nums[i], 0));
            }
            // sorted, important
            Integer[] newNums = getPointMap.keySet()
                    .stream().sorted()
                    .collect(Collectors.toList())
                    .toArray(new Integer[0]);

            int[] records = new int[newNums.length + 1];
            records[0] = 0;
            records[1] = getPointMap.get(newNums[0]);
            for(int i = 2; i <= newNums.length; i++) {
                if(newNums[i - 1] - newNums[i - 2] > 1) {
                    records[i] = records[i - 1] + getPointMap.get(newNums[i - 1]);
                } else {
                    records[i] = Math.max(records[i - 1], records[i - 2] + getPointMap.get(newNums[i - 1]));
                }
            }
//            System.out.println(stringfyArrInteger(newNums));
//            System.out.println(getPointMap);
//            System.out.println(stringfyArr(records));
            return records[newNums.length];
        }
    }
}
