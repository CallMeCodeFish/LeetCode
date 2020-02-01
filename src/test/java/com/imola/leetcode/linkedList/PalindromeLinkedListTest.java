package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/31/20 9:50 PM
 */

/**
 * example 1:
 * Input: 1->2
 * Output: false
 * <p>
 * example 2:
 * Input: 1->2->2->1
 * Output: true
 */

class PalindromeLinkedListTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 1};
        ListNode head = ListNode.create(nums);
        PalindromeLinkedList solution = new PalindromeLinkedList();
        boolean result = solution.isPalindrome2(head);
        System.out.println(result);
    }
}