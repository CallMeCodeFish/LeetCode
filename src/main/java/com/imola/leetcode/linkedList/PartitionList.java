package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/24/20 11:10 PM
 */

/**
 * leetcode 86: Partition List
 *
 * description:
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode header1 = new ListNode(-1); //header node for linked list with values less than x
        ListNode header2 = new ListNode(-1); //header node for linked list with values equal to or greater than x
        ListNode pred1 = header1;
        ListNode pred2 = header2;

        while (head != null) {
            int value = head.val;
            if (value < x) {
                pred1.next = head;
                pred1 = pred1.next;
            } else {
                pred2.next = head;
                pred2 = pred2.next;
            }
            head = head.next;
        }
        pred2.next = null;
        pred1.next = header2.next;
        return header1.next;
    }
}
