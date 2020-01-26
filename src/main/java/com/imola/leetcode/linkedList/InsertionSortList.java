package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/25/20 7:51 PM
 */

/**
 * leetcode 147: Insertion Sort List
 *
 * example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */

public class InsertionSortList {
    public ListNode myInsertionSortList(ListNode head) {
        ListNode header = new ListNode(Integer.MIN_VALUE);
        ListNode sorted = null;
        while (head != null) {
            ListNode cur = head;
            head = head.next;
            if (sorted == null) { //第一个元素
                header.next = sorted = cur;
                cur.next = null;
            } else {
                ListNode pred = binSearch(header, sorted, cur.val);
                cur.next = pred.next;
                pred.next = cur;
                if (pred == sorted) {
                    sorted = pred.next;
                }
            }
        }

        return header.next;
    }

    private ListNode binSearch(ListNode predStart, ListNode predEnd, int value) {
        //edge case

        //找到大于value的最小值对应的node的前驱
        while (predStart != predEnd) {
            ListNode predMid = findMidPred(predStart, predEnd); //中值的前驱
            ListNode mid = predMid.next;
            if (value < mid.val) {
                predEnd = predMid;
            } else { //mid.val <= preStart
                predStart = mid;
            }
        }
        return predStart;
    }

    private ListNode findMidPred(ListNode preStart, ListNode predEnd) {
        ListNode slow = preStart;
        ListNode fast = preStart;

        while (fast != predEnd && fast.next != predEnd) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode header = new ListNode(Integer.MIN_VALUE);

        while (head != null) {
            ListNode target = head;
            head = head.next;
            if (header.next == null) {
                target.next = null;
                header.next = target;
            } else {
                ListNode pred = header;
                while (pred.next != null) {
                    ListNode cur = pred.next;
                    if (target.val < cur.val)
                        break;
                    pred = pred.next;
                }
                target.next = pred.next;
                pred.next = target;
            }
        }

        return header.next;
    }
}
