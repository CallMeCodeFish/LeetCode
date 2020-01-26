package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/25/20 12:24 PM
 */

/**
 * example:
 * Given the sorted linked list: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */

class ConvertSortedListToBSTTest {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        ListNode header = new ListNode(-1);
        ListNode pred = header;
        for (int num : nums) {
            pred.next = new ListNode(num);
            pred = pred.next;
        }

        ConvertSortedListToBST solution = new ConvertSortedListToBST();
        TreeNode result = solution.sortedListToBST(header.next);
        System.out.println(result);
    }
}