package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/23/20 10:31 AM
 */

/**
 * leetcode 206: Reverse Linked List
 *
 * description:
 * Reverse a singly linked list.
 *
 * example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //edge case
        if (head == null)
            return null;

        ListNode left = head;
        ListNode right = head.next;
        ListNode parent = head; //right节点的parent
        while (right != null) {
            parent.next = right.next;
            right.next = left;
            left = right;
            right = parent;
            right = right.next;
        }

        head = left;
        return head;
    }
}
