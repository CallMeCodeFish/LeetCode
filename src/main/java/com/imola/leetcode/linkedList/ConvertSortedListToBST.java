package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/25/20 12:06 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 109: Convert Sorted List to Binary Search Tree
 *
 * description:
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 *
 * example:
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */

public class ConvertSortedListToBST {
    public TreeNode mySortedListToBST(ListNode head) {
        //edge case
        if (head == null)
            return null;

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return dfs(list, 0, list.size());
    }

    private TreeNode dfs(List<Integer> list, int start, int end) {
        //edge case
        if (start == end)
            return null;

        int mid = (start + end) / 2;
        TreeNode cur = new TreeNode(list.get(mid));
        cur.left = dfs(list, start, mid);
        cur.right = dfs(list, mid + 1, end);
        return cur;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    public TreeNode helper(ListNode start, ListNode end) {
        //edge case
        if (start == end)
            return null;

        ListNode mid = findMidListNode(start, end);
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(start, mid);
        root.right = helper(mid.next, end);
        return root;
    }

    private ListNode findMidListNode(ListNode start, ListNode end) {
        ListNode p = start; //move forward by one step
        ListNode q = start; //move forward by two steps
        while (q.next != end && q.next.next != end) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }
}
