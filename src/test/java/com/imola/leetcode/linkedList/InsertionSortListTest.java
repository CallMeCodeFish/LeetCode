package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/25/20 9:28 PM
 */

/**
 * example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * <p>
 * example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */

class InsertionSortListTest {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 1, 3};
        ListNode head = ListNode.create(nums);

        InsertionSortList solution = new InsertionSortList();
        ListNode result = solution.insertionSortList(head);
        System.out.println(result);
    }
}