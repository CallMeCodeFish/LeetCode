package com.imola.leetcode.bitManipulation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/14/20 11:06 PM
 */

/**
 * example 1:
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * <p>
 * example 2:
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * <p>
 * example 3:
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */

class MaximumProductOfWordLengthsTest {
    public static void main(String[] args) {
        MaximumProductOfWordLengths solution = new MaximumProductOfWordLengths();
        String[] words = new String[]{"a", "aa", "aaa", "aaaa"};
        int result = solution.maxProduct(words);
        System.out.println(result);
    }
}