package com.imola.leetcode.bitManipulation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/15/20 12:20 AM
 */

/**
 * example 1:
 * Input: a = 1, b = 2
 * Output: 3
 * <p>
 * example 2:
 * Input: a = -2, b = 3
 * Output: 1
 */

class SumOfTwoIntegersTest {
    public static void main(String[] args) {
        SumOfTwoIntegers solution = new SumOfTwoIntegers();
        int result = solution.getSum(2, 3);
        System.out.println(result);
    }
}