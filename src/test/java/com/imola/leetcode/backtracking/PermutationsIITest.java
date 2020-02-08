package com.imola.leetcode.backtracking;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/7/20 8:16 PM
 */

/**
 * example:
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */

class PermutationsIITest {
    public static void main(String[] args) {
        PermutationsII solution = new PermutationsII();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println(result);
    }
}