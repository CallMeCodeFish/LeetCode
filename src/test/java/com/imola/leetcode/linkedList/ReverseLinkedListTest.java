package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/23/20 11:06 AM
 */

/**
 * example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */

class ReverseLinkedListTest {
    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head= new ListNode(1);
        ListNode cur = head;
        for (int i = 1; i < nums.length; ++i) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

//        System.out.println(head);

        ListNode result = solution.reverseList(null);

        System.out.println("reverse之后");
        System.out.println(result);

    }

}