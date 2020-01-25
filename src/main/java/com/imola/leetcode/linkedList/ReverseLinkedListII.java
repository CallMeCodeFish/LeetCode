package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/24/20 11:43 PM
 */

/**
 * leetcode 92: Reverse Linked List II
 *
 * description:
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list
 *
 * example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //edge case

        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode parent = header;
        for (int i = 0; i < m - 1; ++i) {
            parent = parent.next;
        }
        ListNode pred = parent.next;

        for (int i = m; i < n; ++i) {
            ListNode cur = pred.next;
            pred.next = cur.next;
            cur.next = parent.next;
            parent.next = cur;
        }

        return header.next;
    }
}
