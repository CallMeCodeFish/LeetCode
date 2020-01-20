package com.imola.leetcode.hashtable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/20/20 4:21 PM
 */

/**
 * example:
 *
 * Input:
 * s = "abcd"
 * t = "abcde"
 *
 * Output:
 * e
 *
 * Explanation:
 * 'e' is the letter that was added.
 */

class FindTheDifferenceTest {
    public static void main(String[] args) {
        FindTheDifference findDifference = new FindTheDifference();
        char difference = findDifference.solution(null, "b");
        System.out.println(difference);
    }
}