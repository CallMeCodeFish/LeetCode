package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/24/20 11:05 PM
 */

/**
 * example 1:
 * Input: 1->1->2
 * Output: 1->2
 * <p>
 * example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */

class RemoveDuplicatesTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3};
        ListNode header = new ListNode(-1);
        ListNode pred = header;
        for (int num : nums) {
            pred.next = new ListNode(num);
            pred = pred.next;
        }

        RemoveDuplicates solution = new RemoveDuplicates();
        ListNode result = solution.deleteDuplicates(header.next);
        System.out.println(result);
    }
}