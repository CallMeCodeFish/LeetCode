package com.imola.leetcode.design;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/10/20 11:20 PM
 */

/**
 * example:
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 *
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 */

class PeekingIteratorTest {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        PeekingIterator iterator = new PeekingIterator(nums.iterator());
        System.out.println(iterator.next()); //return 1;
        System.out.println(iterator.peek()); //return 2;
        System.out.println(iterator.peek()); //return 2;
        System.out.println(iterator.next()); //return 2;
        System.out.println(iterator.next()); //return 3;
        System.out.println(iterator.hasNext()); //return false;
    }
}