package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/1/20 12:57 AM
 */

/**
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */

class AddTwoNumbersIITest {
    public static void main(String[] args) {
        int[] nums1 = new int[]{7, 2, 4, 3};
        int[] nums2 = new int[]{5, 5, 6, 4};

        ListNode l1 = ListNode.create(nums1);
        ListNode l2 = ListNode.create(nums2);

        AddTwoNumbersII solution = new AddTwoNumbersII();
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}