package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/28/20 6:09 PM
 */

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 160: Intersection of Two Linked Lists
 *
 * description:
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */

public class IntersectionOfTwoLinkedLists {
    public ListNode myGetIntersectionNode(ListNode headA, ListNode headB) {
        //edge case
        if (headA == null || headB == null)
            return null;

        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        ListNode res = null;
        while (headB != null) {
            if (set.contains(headB)) {
                res = headB;
                break;
            }
            headB = headB.next;
        }

        return res;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode curA = headA;
        int lenA = 0;
        while (curA != null) {
            ++lenA;
            curA = curA.next;
        }

        ListNode curB = headB;
        int lenB = 0;
        while (curB != null) {
            ++lenB;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        if (lenA >= lenB) {
            for (int i = 0; i < lenA - lenB; ++i) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; ++i) {
                curB = curB.next;
            }
        }

        ListNode res = null;
        while (curA != null) {
            if (curA == curB) {
                res = curA;
                break;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return res;
    }
}
