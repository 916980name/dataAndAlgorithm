package com.leetcode.hard;

import com.leetcode.utils.StringfyUtils;

public class Number44 {
    public boolean isMatch(String s, String p) {
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();
        if(sarr.length == 0) {
            for(char c : parr){
                if(c != '*') return false;
            }
        }

        boolean[][] res = new boolean[sarr.length + 1][parr.length + 1];
        res[0][0] = true;
        for(int i = 1; i <= parr.length; i++) {
            res[0][i] = parr[i - 1] == '*';
        }
        int matched = 0;
        for(int i = 1; i <= parr.length; i++) {
            if(matched >= sarr.length && parr[parr.length - 1] != '*') break;
            int j = matched + 1;
            for(; j <= sarr.length; j++) {
                if(res[j - 1][i - 1]) break;
            }
            j = j > 1 ? j - 1 : j;
            boolean col = false;
            boolean matchFlag = false;
            for(; j <= sarr.length; j++) {
                if(parr[i - 1] == '?' || sarr[j - 1] == parr[i - 1]) {
                    res[j][i] = res[j - 1][i - 1];
                    matchFlag = true;
                } else if(parr[i - 1] == '*') {
                    res[j][i] = res[j - 1][i] || res[j][i - 1] || res[j - 1][i - 1];
                }
                if(res[j][i]) col = true;
            }
            if(!col) break;
            if(matchFlag) matched++;
        }
        System.out.println(StringfyUtils.stringfyBoolean2DArray(res));
        return res[sarr.length][parr.length];
    }
}
