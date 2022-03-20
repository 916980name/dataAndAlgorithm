package com.leetcode.hard;

import com.leetcode.excellentResolution.No407;
import com.leetcode.utils.StringfyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Number407 {
    public int trapRainWater(int[][] heightMap) {
//        return new Solution1().trapRainWater(heightMap);
//        return new No407().trapRainWater(heightMap);
        return new Solution2().trapRainWater(heightMap);
    }

    @Deprecated
    class Solution1 {
        public int trapRainWater(int[][] heightMap) {
            List<int[]> res1 = new ArrayList<>();
            List<int[]> res2 = new ArrayList<>();
            for (int i = 0; i < heightMap.length; i++) {
                res1.addAll(trap(heightMap[i], -1, i));
            }
            int[][] newMap = split(heightMap);
            for (int i = 0; i < newMap.length; i++) {
                res2.addAll(trap(newMap[i], i, -1));
            }
            System.out.println(res1.stream().map(i ->
                            StringfyUtils.stringfyIntArray(i))
                    .collect(Collectors.joining()));
            System.out.println(res2.stream().map(i ->
                            StringfyUtils.stringfyIntArray(i))
                    .collect(Collectors.joining()));
            return res1.stream()
                    .map(item ->
                            Math.min(res2.stream().filter(item2 ->
                                                    item[0] == item2[0] && item[1] == item2[1]
                                            ).findFirst()
                                            .orElse(new int[]{0, 0, 0})[2]
                                    , item[2]
                            )
                    )
                    .mapToInt(Integer::intValue)
                    .sum();
        }

        private int[][] split(int[][] origimMap) {
            int[][] newMap = new int[origimMap[0].length][origimMap.length];
            for (int i = 0; i < origimMap[0].length; i++) {
                for (int j = 0; j < origimMap.length; j++) {
                    newMap[i][j] = origimMap[j][i];
                }
            }
            return newMap;
        }

        private List<int[]> trap(int[] height, int x, int y) {
            int left = 0;
            int right = height.length - 1;
            int maxLeft = 0, maxRight = 0;
            List<int[]> res = new ArrayList<>();

            while (left <= right) {
                if (height[left] <= height[right]) {
                    maxLeft = Math.max(maxLeft, height[left]);
                    int cal = maxLeft - height[left];
                    if (cal > 0) {
                        if (x == -1) {
                            res.add(new int[]{left, y, cal});
                        } else {
                            res.add(new int[]{x, left, cal});
                        }
                    }
                    left++;
                } else {
                    maxRight = Math.max(maxRight, height[right]);
                    int cal = maxRight - height[right];
                    if (cal > 0) {
                        if (x == -1) {
                            res.add(new int[]{right, y, cal});
                        } else {
                            res.add(new int[]{x, right, cal});
                        }
                    }
                    right--;
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int trapRainWater(int[][] heightMap) {
            int x = heightMap.length;
            if(x <= 2) return 0;
            int y = heightMap[0].length;
            if(y <= 2) return 0;
            int res = 0;

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            boolean[][] visited = new boolean[x][y];

            for (int i = 0; i < x; i++) {
                queue.offer(new int[] {i, 0, heightMap[i][0]});
                queue.offer(new int[] {i, y - 1, heightMap[i][y - 1]});
                visited[i][0] = visited[i][y - 1] = true;
            }

            for (int j = 1; j < y - 1; j++) {
                queue.offer(new int[] {0, j, heightMap[0][j]});
                queue.offer(new int[] {x - 1, j, heightMap[x - 1][j]});
                visited[0][j] = visited[x - 1][j] = true;
            }

            int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                for(int[] direction : directions) {
                    int px = poll[0] + direction[0];
                    int py = poll[1] + direction[1];
                    if(px < 0 || py < 0 || px >= x || py >= y || visited[px][py]) continue;
                    visited[px][py] = true;
                    int save = poll[2] - heightMap[px][py];
                    if(save > 0) res += save;
                    queue.offer(new int[]{px, py, Math.max(poll[2], heightMap[px][py])});
                }
            }
            return res;
        }
    }
}
