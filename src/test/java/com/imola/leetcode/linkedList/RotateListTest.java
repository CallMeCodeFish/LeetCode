package com.imola.leetcode.linkedList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/23/20 6:37 PM
 */

/**
 * example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * <p>
 * example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */

class RotateListTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        ListNode header = new ListNode(-1);
        ListNode parent = header;
        for (int num : nums) {
            parent.next = new ListNode(num);
            parent = parent.next;
        }
        System.out.println("before:");
        System.out.println(header.next);
        RotateList solution = new RotateList();
        ListNode result = solution.rotateRight(header.next, 0);
        System.out.println(result);
    }
}