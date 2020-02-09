package com.imola.leetcode.backtracking;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/8/20 3:03 PM
 */

/**
 * example 1:
 * Input: "aabb"
 * Output: ["abba", "baab"]
 *
 * example 2:
 * Input: "abc"
 * Output: []
 */

class PalindromePermutationIITest {
    public static void main(String[] args) {
        PalindromePermutationII solution = new PalindromePermutationII();
        List<String> result = solution.generatePalindromes("AaBb//a");
        System.out.println(result);
        System.out.println(result.size());
    }
}