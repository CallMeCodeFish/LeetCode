package com.imola.leetcode.backtracking;

/**
 * @author Heng Yu
 * @date 1/31/20 12:38 PM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 46: Permutations
 *
 * description:
 * Given a collection of distinct integers, return all possible permutations.
 *
 * example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        boolean[] isAvailable = new boolean[nums.length];
        Arrays.fill(isAvailable, true);
        backtracking(nums, isAvailable, res, new ArrayList<>());
        return res;
    }

    private void backtracking(int[] nums, boolean[] isAvailable, List<List<Integer>> res, List<Integer> list) {
        //edge case
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (isAvailable[i]) {
                list.add(nums[i]);
                isAvailable[i] = false;
                backtracking(nums, isAvailable, res, list);
                list.remove(list.size() - 1);
                isAvailable[i] = true;
            }
        }
    }
}
