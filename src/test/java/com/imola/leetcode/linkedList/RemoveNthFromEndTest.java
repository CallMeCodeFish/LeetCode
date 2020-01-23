package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/23/20 1:36 PM
 */

/**
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */


class RemoveNthFromEndTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 1; i < nums.length; ++i) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        System.out.println(head);
        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode result = solution.removeNth(head, 2);
        System.out.println(result);
    }
}