package com.leetcode.easy;

import com.leetcode.easy.ListNode;
import com.leetcode.easy.Number21;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Number21Test {
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

    @Test
    void t1() {
        int[] arr1 = new int[]{1, 2, 4};
        int[] arr2 = new int[]{1, 3, 4};
        ListNode list1 = generate(arr1);
        ListNode list2 = generate(arr2);
        ListNode twoLists = Number21.mergeTwoLists(list1, list2);

        String s = convertToStr(twoLists);
        System.out.println(s);
        Assertions.assertEquals("1,1,2,3,4,4,", s);
    }

    @Test
    void t2() {
        ListNode twoLists = Number21.mergeTwoLists(null, null);

        String s = convertToStr(twoLists);
        System.out.println(s);
        Assertions.assertEquals("[]", s);
    }

    @Test
    void t3() {
        int[] arr2 = new int[]{0};
        ListNode twoLists = Number21.mergeTwoLists(null, generate(arr2));

        String s = convertToStr(twoLists);
        System.out.println(s);
        Assertions.assertEquals("0,", s);
    }
}
