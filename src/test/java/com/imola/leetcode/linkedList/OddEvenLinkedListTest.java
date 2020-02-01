package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/31/20 11:12 PM
 */

/**
 * example 1:
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * <p>
 * example 2:
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 */

class OddEvenLinkedListTest {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] nums = new int[]{2, 1, 3, 5, 6, 4, 7};
        ListNode head = ListNode.create(nums);
        OddEvenLinkedList solution = new OddEvenLinkedList();
        ListNode result = solution.oddEvenList(null);
        System.out.println(result);
    }
}