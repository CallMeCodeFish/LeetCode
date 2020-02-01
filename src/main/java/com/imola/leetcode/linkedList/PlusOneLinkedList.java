package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/31/20 11:25 PM
 */

/**
 * leetcode 369: Plus One Linked List
 *
 * description:
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 *
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * example:
 * Input: [1,2,3]
 * Output: [1,2,4]
 */

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) { // 1 2 3
        //edge case
        if (head == null)
            return null;

        //reverse the list
        ListNode header = new ListNode(-1);
        header.next = head;
        reverse(header, head);
        System.out.println(header.next);

        //add 1 to the list
        ListNode pred = header; // (-1) 9 9 9
        int add = 1;
        while (add != 0) {
            if (pred.next != null) {
                ListNode cur = pred.next;
                int sum = cur.val + add;
                cur.val = sum % 10;
                add = sum / 10;
                pred = pred.next;
            } else {
                pred.next = new ListNode(add);
                break;
            }
        }

        //reverse the list
        head = header.next;
        reverse(header, head);

        //return
        return header.next;
    }

    private void reverse(ListNode header, ListNode head) {
        while (head.next != null) {
            ListNode succ = head.next;
            head.next = succ.next;
            succ.next = header.next;
            header.next = succ;
        }
    }
}
