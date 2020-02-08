package com.imola.leetcode.backtracking;

/**
 * @author Heng Yu
 * @date 2/7/20 8:20 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 77: Combinations
 *
 * description:
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * example:
 * Input: n = 4, k = 2  1,2,3,4
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        //edge case
        if (n < 1 || k < 1)
            return res;

        //dfs
        dfs(1, n, k, res, new ArrayList<>());

        return res;
    }

    private void dfs(int start, int n, int k, List<List<Integer>> res, List<Integer> list) { //n = 4, k = 2  1,2,3,4
        //edge case
        if (k == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < n; ++i) {
            list.add(i);
            dfs(i + 1, n, k, res, list);
            list.remove(list.size() - 1);
        }
    }
}
