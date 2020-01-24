package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/23/20 5:44 PM
 */

/**
 * example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

class SwapNodesInPairsTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        ListNode header = new ListNode(-1);
        ListNode cur = header;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }

        SwapNodesInPairs solution = new SwapNodesInPairs();
        ListNode result = solution.swapPairs(header.next);
        System.out.println(result);
    }
}