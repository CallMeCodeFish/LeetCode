package com.imola.leetcode.bitManipulation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/14/20 11:34 PM
 */

/**
 * example 1:
 * input 16
 * output true
 *
 * example 2:
 * input 5
 * output false
 */

class PowerOfFourTest {
    public static void main(String[] args) {
        PowerOfFour solution = new PowerOfFour();
        boolean result = solution.isPowerOfFour(5);
        System.out.println(result);
    }
}