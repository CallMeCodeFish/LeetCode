package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 1/23/20 10:35 AM
 */


public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);
        sb.append(" -> ");
        ListNode next = this.next;
        while (next != null) {
            sb.append(next.val);
            sb.append(" -> ");
            next = next.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
