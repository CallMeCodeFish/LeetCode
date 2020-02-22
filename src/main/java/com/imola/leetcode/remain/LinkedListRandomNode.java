package com.imola.leetcode.remain;

/**
 * @author Heng Yu
 * @date 2/21/20 7:31 PM
 */

import com.imola.leetcode.linkedList.ListNode;

/**
 * leetcode 382: Linked List Random Node
 *
 * description:
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same
 * probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 *
 * example:
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 */

public class LinkedListRandomNode {
    private ListNode head;
    private long length;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        ListNode cur = head;
        while (cur != null) {
            ++this.length;
            cur = cur.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        long count = (long) (Math.random() * length);
        while (0 < count) {
            cur = cur.next;
            --count;
        }
        return cur.val;
    }
}
