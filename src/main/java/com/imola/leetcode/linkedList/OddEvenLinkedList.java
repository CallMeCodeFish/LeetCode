package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/31/20 10:45 PM
 */

/**
 * leetcode 328: Odd Even Linked List
 *
 * description:
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are
 * talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * example 1:
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * example 2:
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 * Note:
 *  The relative order inside both the even and odd groups should remain as it was in the input.
 *  The first node is considered odd, the second node even and so on ...
 */

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHeader = new ListNode(-1);
        ListNode evenHeader = new ListNode(-1);
        ListNode odd = oddHeader;
        ListNode even = evenHeader;
        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                odd.next = head;
                head = head.next;
                odd = odd.next;
                odd.next = null;
                isOdd = false;
            } else {
                even.next = head;
                head = head.next;
                even = even.next;
                even.next = null;
                isOdd = true;
            }
        }
        odd.next = evenHeader.next;
        return oddHeader.next;
    }
}
