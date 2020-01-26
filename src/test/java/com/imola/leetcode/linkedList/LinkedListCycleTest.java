package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/25/20 3:25 PM
 */

/**
 * example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */

class LinkedListCycleTest {
    public static void main(String[] args) {
        ListNode header = new ListNode(-1);
        int[] nums = new int[]{1};
        ListNode pred = header;
        for (int num : nums) {
            pred.next = new ListNode(num);
            pred = pred.next;
        }
//        pred.next = header.next;

        LinkedListCycle solution = new LinkedListCycle();
        boolean result = solution.hasCycle(header.next);
        System.out.println(result);
    }
}