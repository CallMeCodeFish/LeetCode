package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/31/20 10:41 PM
 */

/**
 * example 1:
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling
 * your function.
 * <p>
 * example 2:
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling
 * your function.
 */

class DeleteNodeTest {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 9};
        ListNode head = ListNode.create(nums);
        DeleteNode solution = new DeleteNode();
        solution.deleteNode(head.next);
        System.out.println(head);
        nums = new int[]{4, 5, 1, 9};
        head = ListNode.create(nums);
        solution.deleteNode(head.next.next);
        System.out.println(head);
    }
}