package com.imola.leetcode.bitManipulation;

/**
 * @author Heng Yu
 * @date 2/12/20 10:12 PM
 */

/**
 * leetcode 137: Single Number II
 *
 * description:
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * example 1:
 * Input: [2,2,3,2]
 * Output: 3
 *
 * example 2:
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */

/**
 * reference:
 * https://blog.csdn.net/u011809767/article/details/77164633
 */

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int num : nums) {
                sum += num >> i & 1;
            }
            res += (sum % 3) << i;
        }
        return res;
    }
}
