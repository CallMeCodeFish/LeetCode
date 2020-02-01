package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/31/20 12:27 PM
 */

/**
 * example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */

class RemoveLinkedListElementsTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 6, 3, 4, 5, 6};
        ListNode head = ListNode.create(nums);
        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        ListNode result = solution.removeElements(head, 1);
        System.out.println(result);
    }
}