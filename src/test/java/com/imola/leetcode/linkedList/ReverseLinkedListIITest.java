package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/25/20 12:19 AM
 */

/**
 * example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */

class ReverseLinkedListIITest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode header = new ListNode(-1);
        ListNode pred = header;
        for (int num : nums) {
            pred.next = new ListNode(num);
            pred = pred.next;
        }

        ReverseLinkedListII solution = new ReverseLinkedListII();
        ListNode result = solution.reverseBetween(header.next, 1, 5);
        System.out.println(result);
    }
}