package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/24/20 10:16 AM
 */

/**
 * leetcode 82: Remove Duplicates from Sorted List II
 *
 * description:
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 *
 * example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 */

public class RemoveDuplicatesII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode pred = header;
        while (pred.next != null) {
            ListNode cur = pred.next;
            ListNode succ = cur.next;
            int count = 1;
            while (succ != null && cur.val == succ.val) {
                ++count;
                succ = succ.next;
            }

            if (count > 1) {
                pred.next = succ;
            } else {
                pred = pred.next;
            }
        }
        return header.next;
    }
}
