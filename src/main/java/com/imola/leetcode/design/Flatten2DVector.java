package com.imola.leetcode.design;

/**
 * @author Heng Yu
 * @date 2/10/20 10:08 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 251: Flatten 2D Vector
 *
 * description:
 * Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and
 * hasNext.
 *
 * example:
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 *
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 *
 * Notes:
 *
 * Please remember to RESET your class variables declared in Vector2D, as static/class variables are persisted across
 * multiple test cases. Please see here for more details.
 * You may assume that next() call will always be valid, that is, there will be at least a next element in the 2d
 * vector when next() is called.
 *
 *
 * Follow up:
 *
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */

public class Flatten2DVector {
    private List<Integer> nums;
    private int top;

    public Flatten2DVector(int[][] v) {
        nums = new ArrayList<>();
        top = 0;
        for (int i = 0; i < v.length; ++i) {
            for (int j = 0; j < v[i].length; ++j) {
                nums.add(v[i][j]);
            }
        }
    }

    public int next() {
        int res = nums.get(top);
        ++top;
        return res;
    }

    public boolean hasNext() {
        return top != nums.size();
    }
}
