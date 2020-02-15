package com.imola.leetcode.bitManipulation;

/**
 * @author Heng Yu
 * @date 2/14/20 11:46 PM
 */

/**
 * leetcode 371: Sum of Two Integers
 *
 * description:
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * example 1:
 * Input: a = 1, b = 2
 * Output: 3
 *
 * example 2:
 * Input: a = -2, b = 3
 * Output: 1
 */

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int res = 0;
        int carry = 0;
        for (int shift = 0; shift < 32; ++shift) {
            int digitA = (a >> shift) & 1;
            int digitB = (b >> shift) & 1;
            boolean hasCarry = false;
            int sum = 0;
            if ((digitA & digitB) == 1)
                hasCarry = true;

            sum = digitA ^ digitB;

            int temp = carry;
            if (hasCarry || (sum & temp) == 1)
                carry = 1;
            else
                carry = 0;

            sum ^= temp;
            res |= sum << shift;
        }
        return res;
    }
}
