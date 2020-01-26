package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/25/20 3:12 PM
 */

/**
 * leetcode 141: Linked List Cycle
 *
 * description:
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in
 * the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode one = header; //move forward by one step
        ListNode two = header; //move forward by two steps

        while (two.next != null && two.next.next != null && one.next != two.next.next) {
            one = one.next;
            two = two.next.next;
        }

        return two.next != null && two.next.next != null;
    }
}
