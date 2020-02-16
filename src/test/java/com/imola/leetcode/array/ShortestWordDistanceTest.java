package com.imola.leetcode.array;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/15/20 6:05 PM
 */

/**
 * example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * <p>
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 */

class ShortestWordDistanceTest {
    public static void main(String[] args) {
        ShortestWordDistance solution = new ShortestWordDistance();
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        int result = solution.shortestDistance(words, word1, word2);
        System.out.println(result);
    }
}