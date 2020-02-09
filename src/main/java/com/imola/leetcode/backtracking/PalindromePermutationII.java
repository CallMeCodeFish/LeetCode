package com.imola.leetcode.backtracking;

/**
 * @author Heng Yu
 * @date 2/8/20 2:14 PM
 */

import java.util.*;

/**
 * leetcode 267: Palindrome Permutation II
 *
 * description:
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no
 * palindromic permutation could be form.
 *
 * example 1:
 * Input: "aabb"
 * Output: ["abba", "baab"]
 *
 * example 2:
 * Input: "abc"
 * Output: []
 */

/**
 * 可以考虑将StringBuilder换成char[]，runtime会更短
 */
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        //edge case
        if (s == null)
            return res;
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        char[] chs = s.toCharArray();
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : chs) {
            if (!counts.containsKey(ch)) {
                counts.put(ch, 0);
            }
            counts.replace(ch, counts.get(ch) + 1);
        }

        int oddCount = 0;
        for (char ch : counts.keySet()) {
            if (counts.get(ch) % 2 == 1)
                ++oddCount;
        }

        if (oddCount > 1)
            return res;

        char odd = '\0';
        for (char ch : counts.keySet()) {
            if (counts.get(ch) % 2 == 1) {
                odd = ch;
                counts.replace(ch, counts.get(ch) - 1);
                break;
            }
        }

        //backtrack
        backtrack(counts, res, new StringBuilder(s.length()), s.length(), odd);

        return res;
    }

    private void backtrack(Map<Character, Integer> counts, List<String> res, StringBuilder builder, int length, char odd) {
        //edge case
        if (length / 2 == builder.length()) {
            String string = builder.toString();
            if ('\0' != odd) {
                string += odd;
            }
            string += builder.reverse().toString();
            res.add(string);
            builder.reverse();
            return;
        }

        Set<Character> chs = counts.keySet();
        for (char ch : chs) {
            if (counts.get(ch) > 0) {
                builder.append(ch);
                counts.replace(ch, counts.get(ch) - 2);
                backtrack(counts, res, builder, length, odd);
                counts.replace(ch, counts.get(ch) + 2);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
