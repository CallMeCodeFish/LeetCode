package com.imola.leetcode.remain;

/**
 * @author Heng Yu
 * @date 2/25/20 6:24 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode Random Pick Index
 *
 * description:
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can
 * assume that the given target number must exist in the array.
 *
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 *
 * example:
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 *
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */

public class RandomPickIndex {
    private int[] nums;
    private Map<Integer, List<Integer>> cache;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.cache = new HashMap<>();
    }

    public int pick(int target) {
        List<Integer> indices = null;
        if (cache.containsKey(target)) {
            indices = cache.get(target);
        } else {
            indices = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                if (target == nums[i]) {
                    indices.add(i);
                }
            }
            cache.put(target, indices);
        }
        int randIndex = (int) (Math.random() * indices.size());
        return indices.get(randIndex);
    }
}
