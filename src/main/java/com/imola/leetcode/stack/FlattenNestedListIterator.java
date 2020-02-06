package com.imola.leetcode.stack;

/**
 * @author Heng Yu
 * @date 2/5/20 5:14 PM
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * leetcode 341: Flatten Nested List Iterator
 *
 * description:
 * Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * example 1:
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,1,2,1,1].
 *
 * example 2:
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,4,6].
 */

public class FlattenNestedListIterator implements Iterator<Integer> {
    private List<Integer> list;
    private int index;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<>();
        this.index = 0;
        //edge case
        if (nestedList != null && !nestedList.isEmpty()) {
            for (NestedInteger ni : nestedList) {
                addIntegerToList(ni);
            }
        }
    }

    private void addIntegerToList(NestedInteger ni) {
        if (ni.isInteger()) {
            list.add(ni.getInteger());
        } else {
            List<NestedInteger> list = ni.getList();
            for (NestedInteger next : list) {
                addIntegerToList(next);
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index != list.size();
    }
}
