package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/31/20 8:49 PM
 */

/**
 * leetcode 234: Palindrome Linked List
 *
 * description:
 * Given a singly linked list, determine if it is a palindrome.
 *
 * example 1:
 * Input: 1->2
 * Output: false
 *
 * example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) { //1 2 3 2 1
        //edge case
        if (head == null)
            return true;

        ListNode first = head;
        //fragment into two list
        ListNode slow = head;
        ListNode fast = head;
        ListNode pred = new ListNode(-1);
        pred.next = slow;
        // 1->2->3 : slow = 2
        // 1->2->3->4 : slow = 3
        while (fast != null && fast.next != null) {
            slow = slow.next;
            pred = pred.next;
            fast = fast.next.next;
        }
        pred.next = null;
        ListNode second = slow;
        System.out.println("first: " + first);
        System.out.println("second: " + second);

        //reverse the second list
        head = new ListNode(-1);
        head.next = second; //head -> 1(second) -> 2 -> 3 -> 4 其实second本身应当是最后一个元素，而head是前哨
        // -1 3 2 1
        while (second.next != null) { //3 | 3
            ListNode succ = second.next;// 2 1 | 1
            second.next = succ.next;// 3 1 | 3 null
            succ.next = head.next; //2 3 1 |
            head.next = succ;//-1 2 3 1
        }
        second = head.next;
        System.out.println("first: " + first);
        System.out.println("second: " + second);

        //compare
        while (first != null) {
            if (first.val != second.val)
                return false;

            first = first.next;
            second = second.next;
        }

        return true;
    }


    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode cur = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            cur = cur.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        System.out.println(cur);
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        ListNode tail = prev;
        while (tail != null) {
            if (tail.val != head.val) {
                return false;
            }
            tail = tail.next;
            head = head.next;
        }

        return true;
    }
}
