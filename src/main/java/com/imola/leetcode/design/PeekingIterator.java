package com.imola.leetcode.design;

/**
 * @author Heng Yu
 * @date 2/10/20 10:57 PM
 */

import java.util.Iterator;
import java.util.List;

/**
 * leetcode 284: Peeking Iterator
 *
 * description:
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that
 * support the peek() operation -- it essentially peek() at the element that will be returned by the next call to
 * next().
 *
 * example:
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 *
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 *
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer peek;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        peek = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek == null)
            peek = iterator.next();
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ret = null;
        if (peek != null) {
            ret = peek;
            peek = null;
        } else {
            ret = iterator.next();
        }
        return ret;
    }

    @Override
    public boolean hasNext() {
        return peek != null || iterator.hasNext();
    }
}
