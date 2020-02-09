package com.imola.leetcode.backtracking;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/8/20 11:42 AM
 */

/**
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

class FactorCombinationsTest {
    public static void main(String[] args) {
        FactorCombinations solution = new FactorCombinations();
        List<List<Integer>> result = solution.getFactors(32);
        System.out.println(result);
    }
}