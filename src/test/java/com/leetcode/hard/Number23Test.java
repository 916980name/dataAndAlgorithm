package com.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.leetcode.hard.Number23.mergeKLists;

class Number23Test {
    public static ListNode generate(int[] arr) {
        ListNode head = null;
        ListNode list = null;
        for(int a : arr) {
            if(list == null) {
                list = new ListNode(a, null);
            } else {
                list.next = new ListNode(a, null);
                list = list.next;
            }
            if(head == null) head = list;
        }
        return head;
    }
    public static String convertToStr(ListNode list) {
        if(list == null) return "[]";
        StringBuilder sb = new StringBuilder();
        while(list != null) {
            sb.append(list.val).append(",");
            list = list.next;
        }
        return sb.toString();
    }
    public ListNode[] construct(ListNode ...nodes) {
        return nodes;
    }

    @Test
    void t1() {
        int[] arr1 = new int[]{1, 4, 5};
        int[] arr2 = new int[]{1, 3, 4};
        int[] arr3 = new int[]{2, 6};
        ListNode[] nodes = construct(generate(arr1),
                generate(arr2), generate(arr3));

        ListNode listNode = mergeKLists(nodes);
        String s = convertToStr(listNode);
        System.out.println(s);
        Assertions.assertEquals("1,1,2,3,4,4,5,6,", s);
    }

    @Test
    void t2() {
        ListNode[] nodes = null;

        ListNode listNode = mergeKLists(nodes);
        String s = convertToStr(listNode);
        System.out.println(s);
        Assertions.assertEquals("[]", s);
    }

    @Test
    void t3() {
        int[] arr1 = new int[]{};
        ListNode[] nodes = construct(generate(arr1));

        ListNode listNode = mergeKLists(nodes);
        String s = convertToStr(listNode);
        System.out.println(s);
        Assertions.assertEquals("[]", s);
    }

    @Test
    void t4() {
        ListNode[] nodes = new ListNode[]{};

        ListNode listNode = mergeKLists(nodes);
        String s = convertToStr(listNode);
        System.out.println(s);
        Assertions.assertEquals("[]", s);
    }
}
