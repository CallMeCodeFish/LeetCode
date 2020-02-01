package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/31/20 11:49 PM
 */

/**
 * example:
 * Input: [1,2,3]
 * Output: [1,2,4]
 */

class PlusOneLinkedListTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        ListNode head = ListNode.create(nums);
        PlusOneLinkedList solution = new PlusOneLinkedList();
        ListNode result = solution.plusOne(head);
        System.out.println(result);
    }
}