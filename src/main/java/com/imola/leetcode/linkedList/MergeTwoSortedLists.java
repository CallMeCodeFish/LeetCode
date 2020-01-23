package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/23/20 2:10 PM
 */

/**
 * leetcode 21: Merge Two Sorted Lists
 *
 * description:
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the
 * nodes of the first two lists.
 *
 * example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode cur = null;
        while (l1 != null || l2 != null) {
            ListNode chosen = null;
            if (l2 == null || l1 != null && l1.val <= l2.val) {
                chosen = l1;
                l1 = l1.next;
            } else {
                chosen = l2;
                l2 = l2.next;
            }
            if (cur == null) {
                res = cur = chosen;
            } else {
                cur.next = chosen;
                cur = cur.next;
            }
        }

        return res;
    }
}
