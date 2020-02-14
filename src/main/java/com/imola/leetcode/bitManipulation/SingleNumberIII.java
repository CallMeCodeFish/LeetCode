package com.imola.leetcode.bitManipulation;

/**
 * @author Heng Yu
 * @date 2/13/20 11:48 PM
 */

/**
 * leetcode 260: Single Number III
 *
 * description:
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
 * exactly twice. Find the two elements that appear only once.
 *
 * example:
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 *
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        //找到diff为1的最低位
        diff &= -diff;

        for (int num : nums) {
            if ((diff & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
