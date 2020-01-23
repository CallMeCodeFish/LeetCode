package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/23/20 2:26 PM
 */

/**
 * example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

class MergeTwoSortedListsTest {
    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 2, 4};
//        int[] nums2 = new int[]{1, 3, 4};

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode result = solution.mergeTwoLists(l1, l2);
        System.out.println(result);
    }
}