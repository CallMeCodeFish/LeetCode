package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/25/20 3:51 PM
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

class LinkedListCycleIITest {
    public static void main(String[] args) {
        ListNode header = new ListNode(-1);
        int[] nums = new int[]{3, 2, 0, -4};
        ListNode pred = header;
        for (int num : nums) {
            pred.next = new ListNode(num);
            pred = pred.next;
        }
        pred.next = header.next.next;

        LinkedListCycleII solution = new LinkedListCycleII();
        ListNode result = solution.detectCycle(header.next);
        if (result == null)
            System.out.println(-1);
        else
            System.out.println(result.val);
    }
}