package com.imola.leetcode.bitManipulation;

/**
 * @author Heng Yu
 * @date 2/14/20 11:10 PM
 */

/**
 * leetcode 342: Power of Four
 *
 * description:
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * example 1:
 * Input: 16
 * Output: true
 *
 * example 2:
 * Input: 5
 * Output: false
 *
 * Follow up: Could you solve it without loops/recursion?
 */

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;
        int ones = 0;
        while (0 < num) {
            if ((num & 1) == 1) {
                ++ones;
                if (ones > 1)
                    return false;
            }
            if (((num >> 1) & 1) == 1)
                return false;
            num >>= 2;
        }

        return true;
    }

    /**
     * Solution not using loops or recursion
     * @param num
     * @return
     */
    public boolean isPowerOfFour2(int num) {
        return num != 0 && ((num&(num-1)) == 0) && (num & 0xAAAAAAAA) == 0;
    }
}
