package com.imola.leetcode.remain;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/25/20 6:38 PM
 */

/**
 * example:
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * <p>
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */

class RandomPickIndexTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        RandomPickIndex solution = new RandomPickIndex(nums);
        int result = -1;
        result = solution.pick(3);
        System.out.println(result);
        result = solution.pick(1);
        System.out.println(result);
    }
}