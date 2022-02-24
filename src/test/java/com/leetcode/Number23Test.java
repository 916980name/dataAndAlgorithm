package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.leetcode.Number21Test.generate;
import static com.leetcode.Number21Test.convertToStr;
import static com.leetcode.Number23.mergeKLists;

class Number23Test {
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
