package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/24/20 11:11 PM
 */

/**
 * example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */

class PartitionListTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2, 5, 2};
        ListNode header = new ListNode(-1);
        ListNode pred = header;
        for (int num : nums) {
            pred.next = new ListNode(num);
            pred = pred.next;
        }

        PartitionList solution = new PartitionList();
        ListNode result = solution.partition(header.next, 3);
        System.out.println(result);
    }
}