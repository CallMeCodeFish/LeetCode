package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/25/20 11:04 PM
 */

/**
 * leetcode 148: Sort List
 *
 * description:
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */

public class SortList {
    public ListNode sortList(ListNode head) {
        return (head == null)? null : mergeSort(head, null);
    }

    private ListNode mergeSort(ListNode start, ListNode end) {
        //edge case
        if (start.next == end) {
            start.next = null;
            return start;
        }

        //find the middle node
        ListNode mid = findMidNode(start, end); //O(n)  1 2
        ListNode left = mergeSort(start, mid); //4 2 1 //4
        ListNode right = mergeSort(mid, end); //2
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode header = new ListNode(-1);
        ListNode cur = header;
        while (left != null || right != null) {
            ListNode target = null;
            if (left != null && right == null || left != null && left.val <= right.val) {
                target = left;
                left = left.next;
            } else {
                target = right;
                right = right.next;
            }
            target.next = null;
            cur.next = target;
            cur = cur.next;
        }
        return header.next;
    }

    private ListNode findMidNode(ListNode start, ListNode end) {
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
