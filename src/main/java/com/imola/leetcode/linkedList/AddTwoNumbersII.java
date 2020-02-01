package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 2/1/20 12:21 AM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 445: Add Two Numbers II
 *
 * description:
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes
 * first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //not reverse the linked list

        ListNode res = new ListNode(-1);
        Map<ListNode, ListNode> m1 = new HashMap<>();
        Map<ListNode, ListNode> m2 = new HashMap<>();

        while (l1.next != null) {
            m1.put(l1.next, l1);
            l1 = l1.next;
        }

        while (l2.next != null) {
            m2.put(l2.next, l2);
            l2 = l2.next;
        }

        int add = 0; //进位
        while (l1 != null || l2 != null) {
            int value1 = 0;
            if (l1 != null)
                value1 = l1.val;

            int value2 = 0;
            if (l2 != null)
                value2 = l2.val;

            int sum = add + value1 + value2;
            ListNode digit = new ListNode(sum % 10);
            add = sum / 10;
            digit.next = res.next;
            res.next = digit;
            if (l1 != null)
                l1 = m1.get(l1);
            if (l2 != null)
                l2 = m2.get(l2);
        }

        if (add != 0) {
            ListNode digit = new ListNode(add);
            digit.next = res.next;
            res.next = digit;
        }

        return res.next;
    }
}
