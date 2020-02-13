package com.imola.leetcode.bitManipulation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/12/20 11:10 PM
 */

/**
 * example 1:
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 *
 * example 2:
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 */

class ReverseBitsTest {
    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        int result = solution.reverseBits(0b11111111111111111111111111111101);
        System.out.println(result);
    }
}