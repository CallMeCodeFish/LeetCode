package com.imola.leetcode.backtracking;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/31/20 1:20 PM
 */

/**
 * example:
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */

class PermutationsTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations solution = new Permutations();
        List<List<Integer>> result = solution.permute(null);
        System.out.println(result);
    }
}