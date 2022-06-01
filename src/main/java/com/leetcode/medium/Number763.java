package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if(s.length() == 0) {
            result.add(0);
            return result;
        }
        char[] chars = s.toCharArray();
        int begin = 0, end = chars.length - 1;
        Map<Character, Integer> cache = new HashMap<>();
        while(begin < chars.length) {
            int findIndex = begin;
            for(int i = chars.length - 1; i >= begin && findIndex < end; i--) {
                Integer theIndex = cache.get(findIndex);
                if(theIndex != null) {
                    if (theIndex > end) {
                        end = theIndex;
                    }
                    findIndex++;
                    i = chars.length - 1;
                    continue;
                }
                if(chars[findIndex] == chars[i] && i > end) {
                    end = i;
                    cache.put(chars[i], i);
                    findIndex++;
                    i = chars.length - 1;
                    continue;
                }
            }
            result.add(end - begin + 1);
            begin = end + 1;
            end = chars.length - 1;
        }
        return result;
    }
}
