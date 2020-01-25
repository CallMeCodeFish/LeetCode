package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/24/20 10:30 AM
 */

/**
 * example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * <p>
 * example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 */

class RemoveDuplicatesIITest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 3};
        ListNode header = new ListNode(0);
        ListNode pred = header;
        for (int num : nums) {
            pred.next = new ListNode(num);
            pred = pred.next;
        }

        RemoveDuplicatesII solution = new RemoveDuplicatesII();
        ListNode result = solution.deleteDuplicates(header.next);
        System.out.println(result);
        System.out.println(System.nanoTime());
    }
}