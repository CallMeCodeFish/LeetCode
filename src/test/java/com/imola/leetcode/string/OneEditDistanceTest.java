package com.imola.leetcode.string;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/18/20 10:39 AM
 */

/**
 * example 1:
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 *
 * example 2:
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 *
 * exmaple 3:
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 */

class OneEditDistanceTest {
    public static void main(String[] args) {
        OneEditDistance solution = new OneEditDistance();
        String s = "";
        String t = "";
        boolean result = solution.isOneEditDistance(s, t);
        System.out.println(result);
    }
}