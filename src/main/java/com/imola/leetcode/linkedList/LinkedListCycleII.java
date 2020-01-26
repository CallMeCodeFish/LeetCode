package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/25/20 3:42 PM
 */

/**
 * leetcode 142: Linked List Cycle II
 *
 * description:
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in
 * the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 */

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null && slow.next != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next == null || fast.next.next == null)
            return null;

        fast = head;
        slow = slow.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
