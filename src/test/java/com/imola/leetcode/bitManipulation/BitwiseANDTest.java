package com.imola.leetcode.bitManipulation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/13/20 11:23 PM
 */

/**
 * example 1:
 * Input: [5,7]
 * Output: 4
 * <p>
 * example 2:
 * Input: [0,1]
 * Output: 0
 *
 * 2147483646
 * 2147483647
 *
 * 0
 * 2147483647
 */

class BitwiseANDTest {
    public static void main(String[] args) {
        BitwiseAND solution = new BitwiseAND();
        int result = solution.rangeBitwiseAnd(0, 2147483647);
        System.out.println(result);
    }
}