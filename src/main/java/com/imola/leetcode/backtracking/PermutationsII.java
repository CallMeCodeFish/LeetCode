package com.imola.leetcode.backtracking;

/**
 * @author Heng Yu
 * @date 2/7/20 6:13 PM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 47: Permutations II
 * <p>
 * description:
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * example
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        //edge case
        if (nums == null || nums.length == 0)
            return res;

        //visited
        boolean[] visited = new boolean[nums.length];

        //sort
        Arrays.sort(nums);

        //permutation
        dfs(nums, res, new ArrayList<>(), visited);

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) { //[1,1,2]
        //edge case
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        int i = 0;
        while (i < nums.length) {
            if (visited[i]) {
                ++i;
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, res, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] != nums[j]) {
                    break;
                }
                ++j;
            }
            i = j;
        }
    }
}