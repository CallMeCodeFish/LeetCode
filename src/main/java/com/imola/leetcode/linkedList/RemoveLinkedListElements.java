package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/31/20 12:22 PM
 */

/**
 * leetcode 203: Remove Linked List Elements
 *
 * description:
 * Remove all elements from a linked list of integers that have value val.
 *
 * example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode pred = header;
        while (pred.next != null) {
            ListNode cur = pred.next;
            if (cur.val == val) {
                pred.next = cur.next;
            } else {
                pred = pred.next;
            }
        }

        return header.next;
    }
}
