package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/23/20 1:18 PM
 */

/**
 * leetcode 19: Remove Nth Node From End of List
 *
 * description:
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Note:
 * Given n will always be valid.
 *
 * example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

public class RemoveNthFromEnd {
    public ListNode removeNth(ListNode head, int n) {
        //edge case

        ListNode cur = head;
        int size = 0; //obtain the size of the linked list

        while (cur != null) {
            ++size;
            cur = cur.next;
        }

        cur = head;
        ListNode parent = null;

        for (int i = 0; i < size - n; ++i) {
            parent = cur;
            cur = cur.next;
        }

        if (n != size) {
            parent.next = cur.next;
        } else {
            head = head.next;
        }

        return head;
    }
}
