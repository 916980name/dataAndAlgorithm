package com.leetcode.easy;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Number21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = null;
        ListNode p = null;
        while(list1 != null || list2 != null) {
            if(list1 == null) {
                if(p == null) {
                    return list2;
                }
                p.next = list2;
                return res;
            }
            if(list2 == null) {
                if(p == null) {
                    return list1;
                }
                p.next = list1;
                return res;
            }
            if(list1.val <= list2.val) {
                if(res == null) {
                    p = res = list1;
                } else {
                    p.next = list1;
                    p = p.next;
                }
                list1 = list1.next;
            } else {
                if(res == null) {
                    p = res = list2;
                } else {
                    p.next = list2;
                    p = p.next;
                }
                list2 = list2.next;
            }
        }
        return res;
    }
}
