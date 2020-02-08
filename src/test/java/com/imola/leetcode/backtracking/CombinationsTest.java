package com.imola.leetcode.backtracking;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/7/20 8:30 PM
 */

/**
 * example:
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */

class CombinationsTest {
    public static void main(String[] args) {
        Combinations solution = new Combinations();
        List<List<Integer>> result = solution.combine(4, 2);
        System.out.println(result);
    }
}