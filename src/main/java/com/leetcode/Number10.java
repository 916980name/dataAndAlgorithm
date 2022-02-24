package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Number10 {
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
        for(int i = 0; i < parr.length;) {
            if(parr[i] >= 'a' && parr[i] <= 'z') {
                if(i + 1 < parr.length && parr[i + 1] == '*') {
                    actions.add(new Actions(TOKEN.CHARS, parr[i]));
                    i += 2;
                } else {
                    actions.add(new Actions(TOKEN.CHAR, parr[i]));
                    i++;
                }
            } else if(parr[i] == '.') {
                if(i + 1 < parr.length && parr[i + 1] == '*') {
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
        for(int i = 0; i < actions.size(); i++) {
            Actions act = actions.get(i);
            if(sIndex >= sarr.length) {
                // means sarr finished, rest of partten must be
                for (int l = i; l < actions.size(); l++) {
                    if(actions.get(l).token != TOKEN.CHARS
                        && actions.get(l).token != TOKEN.ANY_CHARS)
                        return false;
                }
                return true;
            }
            switch (act.token) {
                case CHAR: {
                    if(sarr[sIndex++] != act.value) return false;
                } break;
                case ANY_CHAR: {
                    sIndex++;
                } break;
                case CHARS: {
                    boolean res = isMatch(sarr, sIndex, actions.subList(i + 1, actions.size()));
                    if(res) return true;
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
                    for(int k = begin; k < sarr.length; k++) {
                        if(sarr[k] == target) {
                            boolean res = isMatch(sarr, k, actions.subList(targetIndex, actions.size()));
                            if(res) return true;
                        }
                    }
                    return false;
                }
            }
        }
        if(sIndex >= sarr.length) return true;
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("aabbbccddddf", "a*bbbc*...d."));
//        System.out.println(isMatch("ccavabaaab", "c*.va.*b"));
//        System.out.println(isMatch("aaa", "aaaa")); // false
//        System.out.println(isMatch("a", "ab*")); // true
//        System.out.println(isMatch("ab", ".*..")); // true
//        System.out.println(isMatch("ab", ".*..c*")); // true
//        System.out.println(isMatch("ab", ".*.c*b")); // true
        // TODO
        System.out.println(isMatch("abbbcd", "ab*bbbcd")); // true
    }

}
