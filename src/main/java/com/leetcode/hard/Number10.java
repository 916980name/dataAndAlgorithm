package com.leetcode.hard;

import com.leetcode.excellentResolution.No10;

import java.util.ArrayList;
import java.util.List;

// TODO unaccomplished
public class Number10 {
    public boolean isMatch(String s, String p) {
//        return Solution1.isMatch(s, p);
        return new Solution2().isMatch(s, p);
//        return new No10().isMatch(s, p);
    }

    @Deprecated
    // because not work
    static class Solution1 {
        enum TOKEN {
            CHAR, ANY_CHAR, CHARS, ANY_CHARS
        }

        static class Actions {
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

        private static List<Actions> preprocceed(String p) {
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
                        actions.add(new Actions(TOKEN.ANY_CHARS, null));
                        i += 2;
                    } else {
                        actions.add(new Actions(TOKEN.ANY_CHAR, null));
                        i++;
                    }
                }
            }
            return actions;
        }

        public static boolean isMatch(String s, String p) {
            List<Actions> actions = preprocceed(p);
            System.out.println(actions);
            char[] sarr = s.toCharArray();
            return isMatch(sarr, 0, actions);
        }

        public static boolean isMatch(char[] sarr, int beginIndex, List<Actions> actions) {
            int sIndex = beginIndex;
            for (int i = 0; i < actions.size(); i++) {
                Actions act = actions.get(i);
                if (sIndex >= sarr.length) {
                    // means sarr finished, rest of partten must be
                    for (int l = i; l < actions.size(); l++) {
                        if (actions.get(l).token != TOKEN.CHARS
                                && actions.get(l).token != TOKEN.ANY_CHARS)
                            return false;
                    }
                    return true;
                }
                switch (act.token) {
                    case CHAR: {
                        if (sarr[sIndex++] != act.value) return false;
                    }
                    break;
                    case ANY_CHAR: {
                        sIndex++;
                    }
                    break;
                    case CHARS: {
                        boolean res = isMatch(sarr, sIndex, actions.subList(i + 1, actions.size()));
                        if (res) return true;
                        res = isMatch(sarr, sIndex + 1, actions.subList(i + 1, actions.size()));
                        return res;
                    }
                    case ANY_CHARS: {
                        int j = i + 1;
                        int interval = 0;
                        int targetIndex = 0;
                        while (j < actions.size()) {
                            if (actions.get(j).token == TOKEN.ANY_CHAR) {
                                interval++;
                            }
                            if (actions.get(j).token == TOKEN.CHAR) {
                                targetIndex = j;
                                break;
                            }
                            j++;
                        }
                        if (interval > sarr.length - sIndex) return false;
                        if (targetIndex == 0) return true;

                        int begin = sIndex + interval;
                        char target = actions.get(targetIndex).value;
                        for (int k = begin; k < sarr.length; k++) {
                            if (sarr[k] == target) {
                                boolean res = isMatch(sarr, k, actions.subList(targetIndex, actions.size()));
                                if (res) return true;
                            }
                        }
                        return false;
                    }
                }
            }
            if (sIndex >= sarr.length) return true;
            return false;

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
