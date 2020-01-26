package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/26/20 12:08 AM
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

class SortListTest {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 5, 3, 4, 0};
        ListNode head = ListNode.create(nums);
        SortList solution = new SortList();
        ListNode result = solution.sortList(null);
        System.out.println(result);
    }
}