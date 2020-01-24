package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/23/20 6:11 PM
 */

/** leetcode 61: Rotate List
 *
 * description:
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 * example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        //edge case
        if (head == null)
            return null;

        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode parent = header;

        //find the length of the input linked list
        int size = 0;
        while (parent.next != null) {
            ++size;
            parent = parent.next;
        }
        ListNode last = parent;
        parent = header;

        //find the complement number of k to size
        k %= size;
        //edge case
        if (k == 0)
            return head;

        int complement = size - k;
        while (complement > 0) {
            parent = parent.next;
            --complement;
        }

        header.next = parent.next;
        parent.next = null;
        last.next = head;

        return header.next;
    }
}
