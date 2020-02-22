package com.imola.leetcode.remain;

/**
 * @author Heng Yu
 * @date 2/21/20 8:17 PM
 */

import java.util.Arrays;

/**
 * leetcode 384: Shuffle an Array
 *
 * description:
 * Shuffle a set of numbers without duplicates.
 *
 * example:
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */

public class ShuffleArray {
    private int[] nums;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffle = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < shuffle.length; ++i) {
            int curLength = shuffle.length - i;
            int j = (int) (Math.random() * curLength) + i;
            int temp = shuffle[i];
            shuffle[i] = shuffle[j];
            shuffle[j] = temp;
        }
        return shuffle;
    }
}
