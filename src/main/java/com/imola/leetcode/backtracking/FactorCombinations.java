package com.imola.leetcode.backtracking;

/**
 * @author Heng Yu
 * @date 2/8/20 12:01 AM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 254: Factor Combinations
 *
 * description:
 * Numbers can be regarded as product of its factors. For example,
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 *
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * Note:
 *
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 *
 * example 1:
 * Input: 1
 * Output: []
 *
 * example 2:
 * Input: 37
 * Output:[]
 *
 * example 3:
 * Input: 12
 * Output:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 *
 * example 4:
 * Input: 32
 * Output:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 */

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, 2, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int n, int start, List<List<Integer>> res, List<Integer> list) {
        for (int i = start; i <= n / i; ++i) {
            if (n % i == 0) {
                list.add(i);
                list.add(n / i);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                //backtracking
                backtrack(n / i, i, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
