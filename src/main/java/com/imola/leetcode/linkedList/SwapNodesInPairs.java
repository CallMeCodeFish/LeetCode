package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/23/20 5:22 PM
 */

import java.awt.*;

/**
 * leetcode 24: Swap Nodes in Pairs
 *
 * description:
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;

        ListNode parent = new ListNode(-1);
        ListNode header = parent;
        parent.next = head;

        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            parent.next = second;
            parent = first;
            first = first.next;
            second = (first == null)? null : first.next;
        }

        return header.next;
    }
}
