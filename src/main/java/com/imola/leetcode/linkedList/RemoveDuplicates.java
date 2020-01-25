package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/24/20 10:47 PM
 */

/**
 * leetcode 83: Remove Duplicates from Sorted List
 *
 * description:
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */

public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode pred = header;

        while (pred.next != null) {
            ListNode cur = pred.next;
            ListNode succ = cur.next;
            while (succ != null && cur.val == succ.val) {
                succ = succ.next;
            }
            cur.next = succ;
            pred = pred.next;
        }

        return header.next;
    }
}
