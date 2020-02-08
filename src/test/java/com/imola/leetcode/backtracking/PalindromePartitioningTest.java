package com.imola.leetcode.backtracking;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/7/20 10:56 PM
 */

/**
 * example:
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */

class PalindromePartitioningTest {
    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        List<List<String>> result = solution.partition("");
        System.out.println(result);
    }
}