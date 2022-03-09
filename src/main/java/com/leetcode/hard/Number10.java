package com.leetcode.hard;

import com.leetcode.excellentResolution.No10;
import com.leetcode.utils.StringfyUtils;

import java.util.ArrayList;
import java.util.List;

import static com.leetcode.hard.Number10.TOKEN.*;

// TODO unaccomplished
public class Number10 {
    public boolean isMatch(String s, String p) {
        return new Solution1().isMatch(s, p);
//        return new Solution2().isMatch(s, p);
//        return new No10().isMatch(s, p);
    }

    enum TOKEN {
        CHAR, ANY_CHAR, CHARS, ANY_CHARS
    }

    // Anyway, it worked
    class Solution1 {
        class Actions {
            public TOKEN token;
            public Character value;

            public Actions(TOKEN token, Character value) {
                this.token = token;
                this.value = value;
            }

            @Override
            public String toString() {
                return "{token:" + token + ", value:" + value + '}';
            }
        }

        private List<Actions> preprocceed(String p) {
            List<Actions> actions = new ArrayList<>();
            char[] parr = p.toCharArray();
            for (int i = 0; i < parr.length; ) {
                if (parr[i] >= 'a' && parr[i] <= 'z') {
                    if (i + 1 < parr.length && parr[i + 1] == '*') {
                        actions.add(new Actions(TOKEN.CHARS, parr[i]));
                        i += 2;
                    } else {
                        actions.add(new Actions(TOKEN.CHAR, parr[i]));
                        i++;
                    }
                } else if (parr[i] == '.') {
                    if (i + 1 < parr.length && parr[i + 1] == '*') {
                        actions.add(new Actions(ANY_CHARS, null));
                        i += 2;
                    } else {
                        actions.add(new Actions(TOKEN.ANY_CHAR, null));
                        i++;
                    }
                }
            }
            return actions;
        }

        public boolean isMatch(String s, String p) {
            List<Actions> actions = preprocceed(p);
            System.out.println(actions);
            return isMatch(s.toCharArray(), actions.toArray(new Actions[0]));
        }

        /**
         *actions0   1   2
         *       c * a * b ...
         *     0 1   2   3 4 5
         *   0 y n   y   n y n
         * a 1 n
         * a 2 n
         * b 3 n
         */
        public boolean isMatch(char[] sarr, Actions[] actions) {
            if(actions.length == 0) {
                return sarr.length == 0;
            }

            boolean[][] res = new boolean[sarr.length + 1][actions.length + 1];
            res[0][0] = true;
            for(int i = 0; i < actions.length; i++) {
                res[0][i + 1] = (actions[i].token == CHARS || actions[i].token == ANY_CHARS)
                        && res[0][i];
            }
            for(int i = 1; i < actions.length + 1; i++) {
                for(int j = 1; j < sarr.length + 1; j++) {
                    switch (actions[i - 1].token) {
                        case CHAR:
                            if(sarr[j - 1] == actions[i - 1].value) {
                                res[j][i] = res[j - 1][i - 1];
                            }
                            break;
                        case ANY_CHAR:
                            res[j][i] = res[j - 1][i - 1];
                            break;
                        case CHARS:
                            res[j][i] = res[j][i - 1] || (sarr[j - 1] == actions[i - 1].value && res[j - 1][i]);
                            break;
                        case ANY_CHARS:
                            res[j][i] = res[j][i - 1] || res[j - 1][i];
                            break;
                    }
                }
            }
            System.out.println(StringfyUtils.stringfyBoolean2DArray(res));
            return res[sarr.length][actions.length];
        }
    }

    @Deprecated
    class Solution2 {
        private static final char EMPTY_TARGET = ' ';
        private boolean matchFlag = false;

        public boolean isMatch(String s, String p) {
            char[] sArr = s.toCharArray();
            char[] pArr = p.toCharArray();
            isMatch(sArr, 0, pArr, 0, EMPTY_TARGET);
            return matchFlag;
        }

        public void isMatch(char[] sArr, int sBegin, char[] pArr, int pBegin, char target) {
            System.out.println(stringfyWithIndex(sArr, sBegin, pArr, pBegin) + "\t\t target: " + target);
            if(matchFlag) return;
            if(target != EMPTY_TARGET) {
                if(sBegin < sArr.length && sArr[sBegin] == target) {
                    System.out.println("[t: " + target + "] s :" + (sBegin + 1) + ", p: " + (pBegin));
                    isMatch(sArr, sBegin + 1, pArr, pBegin, EMPTY_TARGET);
                    isMatch(sArr, sBegin + 1, pArr, pBegin, target);
                } else {
                    System.out.println("NOT MATCH t: " + target);
                    return;
                }
            }
            if(pBegin == pArr.length) {
                if(sBegin == sArr.length) {
                    System.out.println("found: " + sBegin + ", " + pBegin);
                    matchFlag = true;
                }
                return;
            }
            if(pArr[pBegin] == '.') {
                if(pBegin + 1 < pArr.length && pArr[pBegin + 1] == '*') {
                    for(int i = 0; i <= sArr.length - sBegin; i++) {
                        System.out.println("[.*] s :" + (sBegin + i) + ", p: " + (pBegin + 2));
                        isMatch(sArr, sBegin + i, pArr, pBegin + 2, EMPTY_TARGET);
                    }
                } else {
                    System.out.println("[.] s :" + (sBegin + 1) + ", p: " + (pBegin + 1));
                    isMatch(sArr, sBegin + 1, pArr, pBegin + 1, EMPTY_TARGET);
                }
            } else {
                if(pBegin + 1 < pArr.length && pArr[pBegin + 1] == '*') {
                    for(int i = 0; i <= sArr.length - sBegin; i++) {
                        if(i == 0) {
                            System.out.println("[" + pArr[pBegin] + "*] 0s :" + (sBegin + i) + ", p: " + (pBegin + 2));
                            isMatch(sArr, sBegin + i, pArr, pBegin + 2, EMPTY_TARGET);
                        }
                        System.out.println("[" + pArr[pBegin] + "*] s :" + (sBegin + i) + ", p: " + (pBegin + 2));
                        isMatch(sArr, sBegin + i, pArr, pBegin + 2, pArr[pBegin]);
                        if(!matchFlag) break;
                    }
                } else if(sBegin < sArr.length && sArr[sBegin] == pArr[pBegin]){
                    System.out.println("[" + pArr[pBegin] + "] s :" + (sBegin + 1) + ", p: " + (pBegin + 1));
                    isMatch(sArr, sBegin + 1, pArr, pBegin + 1, EMPTY_TARGET);
                }
            }
            System.out.println("NOT MATCH");
            return;
        }

        private String stringfyWithIndex(char[] sArr, int sBegin, char[] pArr, int pBegin) {
            StringBuilder buf = new StringBuilder();
            buf.append(sArr).append(", ").append(pArr).append("\n");
            for(int i = 0; i < sBegin; i++) {
                buf.append(" ");
            }
            buf.append("^");
            for(int i = 0; i < (sArr.length - sBegin - 1) + 2 + pBegin; i++) {
                buf.append(" ");
            }
            buf.append("^");
            return buf.toString();
        }
    }

}
