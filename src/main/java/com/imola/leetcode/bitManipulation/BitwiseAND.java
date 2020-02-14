package com.imola.leetcode.bitManipulation;

/**
 * @author Heng Yu
 * @date 2/13/20 11:10 PM
 */

/**
 * leetcode 201: Bitwise AND of Numbers Range
 *
 * description:
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * example 1:
 * Input: [5,7]
 * Output: 4
 *
 * example 2:
 * Input: [0,1]
 * Output: 0
 */

public class BitwiseAND {
    public int myRangeBitwiseAnd(int m, int n) {
        int res = Integer.MAX_VALUE;
        for (int i = m; i <= n; ++i) {
            res &= i;
            if (res == 0 || Integer.MAX_VALUE == i)
                break;
        }
        return res;
    }

    /**
     * 通过右移操作找到最大值和最小值的共同前缀，然后将当前的最小值左移
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
}
