package com.imola.leetcode.remain;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/22/20 11:31 PM
 */

/**
 * example 1:
 * Input:
 * s = "aaabb", k = 3
 *
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 *
 * example 2:
 * Input:
 * s = "ababbc", k = 2
 *
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */

class LongestSubstringWithKRepeatingTest {
    public static void main(String[] args) {
        LongestSubstringWithKRepeating solution = new LongestSubstringWithKRepeating();
        String s = "aaabbbcdefcdefgggggggggggggggcde";
        int k = 3;
        int result = solution.longestSubstring2(s, k);
        System.out.println(result);
    }
}