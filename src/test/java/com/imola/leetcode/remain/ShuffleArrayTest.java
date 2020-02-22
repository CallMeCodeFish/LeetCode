package com.imola.leetcode.remain;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/21/20 8:47 PM
 */

/**
 * example:
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */

class ShuffleArrayTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        ShuffleArray solution = new ShuffleArray(nums);
        int[] result = null;
        result = solution.shuffle();
        System.out.println(Arrays.toString(result));
        result = solution.reset();
        System.out.println(Arrays.toString(result));
        result = solution.shuffle();
        System.out.println(Arrays.toString(result));
    }
}