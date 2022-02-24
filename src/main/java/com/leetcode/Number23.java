package com.leetcode;


/*class ListNode {
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
}*/

public class Number23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode p = head;
        int emptyCount = 0;
        while(lists != null) {
            emptyCount = 0;
            Integer min = null, minIndex = null;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] == null) {
                    emptyCount++;
                    continue;
                }
                if (min == null || lists[i].val < min){
                    min = lists[i].val;
                    minIndex = i;
                }
            }
            if(emptyCount == lists.length) return head.next;

            p.next = lists[minIndex];
            p = p.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return head.next;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode p = head;
        int emptyCount = 0;
        while (lists != null) {
            emptyCount = 0;
            Integer min = null, minIndex = null;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    emptyCount++;
                    continue;
                }
                if (min == null || lists[i].val < min) {
                    min = lists[i].val;
                    minIndex = i;
                }
            }
            if (emptyCount == lists.length) return head.next;

            p.next = lists[minIndex];
            p = p.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return head.next;
    }
}
