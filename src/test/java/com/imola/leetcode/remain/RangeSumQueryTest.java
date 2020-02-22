package com.imola.leetcode.remain;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/21/20 3:48 PM
 */

/**
 * example:
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 */

class RangeSumQueryTest {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 9, 5, 7, 3};
        RangeSumQuery2 solution = new RangeSumQuery2(nums);
        System.out.println(solution.sumRange(4, 4));
    }
}