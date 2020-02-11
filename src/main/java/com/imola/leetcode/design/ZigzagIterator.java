package com.imola.leetcode.design;

/**
 * @author Heng Yu
 * @date 2/10/20 10:43 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 281: Zigzag Iterator
 *
 * description:
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 *
 * example:
 * Input:
 * v1 = [1,2]
 * v2 = [3,4,5,6]
 * Output: [1,3,2,4,5,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next
 * should be: [1,3,2,4,5,6].
 *
 * Follow up:
 *
 * What if you are given k 1d vectors? How well can your code be extended to such cases?
 *
 * Clarification for the follow up question:
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you,
 * replace "Zigzag" with "Cyclic". For example:
 * Input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 *
 * Output: [1,4,8,2,5,9,3,6,7].
 */

public class ZigzagIterator {
    private List<Integer> nums;
    private int top;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        nums = new ArrayList<>();
        top = 0;
        if (v1 != null && !v1.isEmpty() && v2 != null && !v2.isEmpty()) {
            int i = 0;
            while (i < v1.size() || i < v2.size()) {
                if (i < v1.size()) {
                    nums.add(v1.get(i));
                }
                if (i < v2.size()) {
                    nums.add(v2.get(i));
                }
                ++i;
            }
        } else if (v1 != null && !v1.isEmpty()) {
            nums.addAll(v1);
        } else if (v2 != null && !v2.isEmpty()) {
            nums.addAll(v2);
        }
    }

    public int next() {
        return nums.get(top++);
    }

    public boolean hasNext() {
        return top != nums.size();
    }
}
