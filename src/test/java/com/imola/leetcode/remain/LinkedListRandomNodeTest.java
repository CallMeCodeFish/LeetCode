package com.imola.leetcode.remain;

import com.imola.leetcode.linkedList.ListNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/21/20 8:09 PM
 */

/**
 * example:
 */

class LinkedListRandomNodeTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        ListNode head = ListNode.create(nums);
        LinkedListRandomNode solution = new LinkedListRandomNode(head);
        int result = solution.getRandom();
        System.out.println(result);
    }
}