package com.leetcode.hard;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Number715 {
    private TreeMap<Integer, Integer> map;

    public Number715() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        int insertKey = left, insertValue = right;
        Integer next = left;

        Set<Integer> removeKeys = new TreeSet<>();
        // Lkey-----left-----Lvalue-----
        Integer lowerKey = map.lowerKey(left);
        if (lowerKey != null) {
            Integer lValue = map.get(lowerKey);
            if (left <= lValue) {
                insertKey = lowerKey;
            }
            next = lValue;
        }

        // ---k1---v1---k2---v2---
        while(next != null) {
            if(right > next) {
                removeKeys.add(next);
                next = map.higherKey(next);
                if (next != null) {
                    if (right >= next) {
                        removeKeys.add(next);
                        int rv = map.get(next);
                        // ---k1---right---v1(rv)---
                        if (right <= rv) {
                            insertValue = rv;
                            break;
                        }
                        next = rv;
                    } else {
                        insertValue = right;
                        break;
                    }
                }
            } else {
                insertValue = next;
                break;
            }
        }
        removeKeys.stream().forEach(item -> map.remove(item));
        map.put(insertKey, insertValue);
        System.out.println("l: " + left
                + ", r: " + right
                + ", remove: " + removeKeys.toString()
                + ", res: " + stringfy());
    }

    public boolean queryRange(int left, int right) {
        System.out.println("[query] " + left + ", " + right);
        Integer value = map.get(left);
        if(value != null && right <= value) return true;

        if(value == null) {
            Integer lowerKey = map.lowerKey(left);
            if (lowerKey != null && right <= map.get(lowerKey)) return true;
        }

        return false;
    }

    public void removeRange(int left, int right) {
        Integer next = left;

        Set<Integer> removeKeys = new TreeSet<>();
        Map<Integer, Integer> addMap = new HashMap<>();
        Integer value = map.get(left);
        if(value != null) {
            removeKeys.add(left);
            next = value;
        } else {
            Integer lowerKey = map.lowerKey(left);
            if (lowerKey != null) {
                Integer lValue = map.get(lowerKey);
                if (left < lValue) {
                    removeKeys.add(lowerKey);
                    addMap.put(lowerKey, left);
                }
                if (right < lValue) {
                    addMap.put(right, lValue);
//                return;
                }
                next = lValue;
            }
        }

        while(next != null) {
            if(right >= next) {
                removeKeys.add(next);
                next = map.higherKey(next);
                if (next != null) {
                    if (right > next) {
                        removeKeys.add(next);
                        int rv = map.get(next);
                        // ---k1---right---v1(rv)---
                        if (right < rv) {
                            addMap.put(right, rv);
                            break;
                        }
                        next = rv;
                    } else {
                        break;
                    }
                }
            } else {
                addMap.put(right, next);
                break;
            }
        }
        removeKeys.stream().forEach(item -> map.remove(item));
        map.putAll(addMap);
        System.out.println("[remove] l: " + left
                + ", r: " + right
                + ", remove: " + removeKeys.toString()
                + ", res: " + stringfy());
    }

    public String stringfy() {
        StringBuilder buf = new StringBuilder();
        map.keySet().stream()
                .forEach(item ->
                        buf.append(item).append("-")
                                .append(map.get(item))
                                .append(","));
        return buf.toString();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
