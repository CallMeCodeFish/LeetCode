package com.imola.leetcode.slidingwindow;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/20/20 4:48 PM
 */

/**
 * example 1:
 * Input:
 * s = "ABAB", k = 2
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * <p>
 * <p>
 * example 2:
 * Input:
 * s = "AABABBA", k = 1
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */

class LongestRepeatingCharacterReplacementTest {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
//        int s1 = solution.characterReplacement("ABAB", 2);
//        System.out.println("s1: " + s1);

        int s2 = solution.characterReplacement("EOEMQLLQTRQDDCOERARHGAAARRBKCCMFTDAQOLOKARBIJBISTGNKBQGKKTALSQNFSABASNOPBMMGDIOETPTDICRBOMBAAHINTFLH", 7);
        System.out.println("s2: " + s2);
    }
}