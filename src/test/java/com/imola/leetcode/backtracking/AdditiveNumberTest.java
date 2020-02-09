package com.imola.leetcode.backtracking;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/8/20 6:25 PM
 */

/**
 * example 1:
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 * example 2:
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199.
 *              1 + 99 = 100, 99 + 100 = 199
 */

class AdditiveNumberTest {
    public static void main(String[] args) {
        AdditiveNumber solution = new AdditiveNumber();
        boolean result = solution.isAdditiveNumber("101");
        System.out.println(result);
    }
}