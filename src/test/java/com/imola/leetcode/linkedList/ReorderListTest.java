package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/25/20 5:26 PM
 */

/**
 * example 1:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * <p>
 * example 2:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

class ReorderListTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        ListNode header = new ListNode(-1);
        ListNode pred = header;
        for (int num : nums) {
            pred.next = new ListNode(num);
            pred = pred.next;
        }

        ReorderList solution = new ReorderList();
        solution.reorderList(header.next);
        System.out.println(header.next);
    }
}