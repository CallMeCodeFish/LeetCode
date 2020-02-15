package com.imola.leetcode.bitManipulation;

/**
 * @author Heng Yu
 * @date 2/14/20 10:17 PM
 */

/**
 * leetcode : Maximum Product of Word Lengths
 *
 * description:
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do
 * not share common letters. You may assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 *
 * example 1:
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 *
 * example 2:
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 *
 * example 3:
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        //edge case
        if (words == null || words.length == 0)
            return 0;

        int res = 0;
        int[] bitMasks = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            bitMasks[i] = calcBitMask(words[i]);
        }

        for (int i = 0; i < words.length; ++i) {
            int bitMask1 = bitMasks[i];
            for (int j = i + 1; j < words.length; ++j) {
                int bitMask2 = bitMasks[j];
                if ((bitMask1 & bitMask2) == 0) {
                    int product = words[i].length() * words[j].length();
                    res = Math.max(res, product);
                }
            }
        }
        return res;
    }

    private int calcBitMask(String word) {
        int ret = 0;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int shift = c - 'a';
            ret |= 1 << shift;
        }
        return ret;
    }
}
