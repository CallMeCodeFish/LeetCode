package com.imola.leetcode.linkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/28/20 6:17 PM
 */


class IntersectionOfTwoLinkedListsTest {
    public static void main(String[] args) {
        int[] numsA = new int[]{4, 1, 8, 4, 5};
        int[] numsB1 = new int[]{5, 0, 1};
        int[] numsB2 = new int[]{4, 5};
        ListNode headA = ListNode.create(numsA);
        ListNode intersection = headA.next.next;
        ListNode headB = ListNode.create(numsB1);
        ListNode cur = headB;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = intersection;
        cur = cur.next;
        ListNode temp = ListNode.create(numsB2);
        cur.next = temp;
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
        ListNode result = solution.getIntersectionNode(headA, headB);
        System.out.println(result);
    }
}