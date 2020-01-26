package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/25/20 4:42 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 143: Reorder List
 * <p>
 * description:
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * example 1:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * <p>
 * example 2:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

public class ReorderList {
    public void myReorderList(ListNode head) {
        //edge case
        if (head == null)
            return;

        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        ListNode left = head;
        int mid = (nodes.size() - 1) / 2;
        int j = nodes.size() - 1;
        for (int i = 0; i <= mid; ++i) {
            ListNode right = nodes.get(j);
            if (i != mid) {
                right.next = left.next;
                left.next = right;
                left = right.next;
                j--;
            } else {
                if (left == right) {
                    left.next = null;
                } else {
                    right.next = null;
                }
            }
        }
    }

    /**
     * https://www.cnblogs.com/grandyang/p/4254860.html
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        if (second == null)
            return;

        slow.next = null;
        ListNode first = head;

        ListNode header = new ListNode(-1);
        header.next = second;
        while (second.next != null) {
            ListNode cur = second.next;
            second.next = cur.next;
            cur.next = header.next;
            header.next = cur;
        }
        second = header.next;

        while (second != null) {
            ListNode cur = second;
            second = second.next;
            cur.next = first.next;
            first.next = cur;
            first = cur.next;
        }
    }
}
