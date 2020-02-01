package com.imola.leetcode.linkedList;

/**
 * @author Heng Yu
 * @date 2/1/20 12:00 AM
 */

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 379: Design Phone Directory
 *
 * description:
 * Design a Phone Directory which supports the following operations:
 *
 * 1. get: Provide a number which is not assigned to anyone.
 * 2. check: Check if a number is available or not.
 * 3. release: Recycle or release a number.
 *
 * example:
 * // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
 * PhoneDirectory directory = new PhoneDirectory(3);
 *
 * // It can return any available phone number. Here we assume it returns 0.
 * directory.get();
 *
 * // Assume it returns 1.
 * directory.get();
 *
 * // The number 2 is available, so return true.
 * directory.check(2);
 *
 * // It returns 2, the only number that is left.
 * directory.get();
 *
 * // The number 2 is no longer available, so return false.
 * directory.check(2);
 *
 * // Release number 2 back to the pool.
 * directory.release(2);
 *
 * // Number 2 is available again, return true.
 * directory.check(2);
 */

public class DesignPhoneDirectory {
    private ListNode header;
    private Set<Integer> set;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) { // 3: 0 1 2
        header = new ListNode(-1);
        set = new HashSet<>();
        ListNode cur = header;
        for (int i = 0; i < maxNumbers; ++i) {
            cur.next = new ListNode(i);
            cur = cur.next;
            set.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (set.size() == 0)
            return -1;
        ListNode first = header.next;
        header.next = first.next;
        set.remove(first.val);
        return first.val;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (set.contains(number))
            return;
        set.add(number);
        ListNode first = new ListNode(number);
        first.next = header.next;
        header.next = first;
    }
}
