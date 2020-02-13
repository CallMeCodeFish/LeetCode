package com.imola.leetcode.bitManipulation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/12/20 11:19 PM
 */


class NumberOfOneBitsTest {
    public static void main(String[] args) {
        NumberOfOneBits solution = new NumberOfOneBits();
        int result = solution.hammingWeight(0b11111111111111111111111111111101);
        System.out.println(result);
    }
}