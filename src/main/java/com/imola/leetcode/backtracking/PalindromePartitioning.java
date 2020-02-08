package com.imola.leetcode.backtracking;

/**
 * @author Heng Yu
 * @date 2/7/20 10:36 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 131: Palindrome Partitioning
 *
 * description:
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * example:
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        //edge case
        if (s == null)
            return res;

        dfs(s, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int i, List<List<String>> res, List<String> list) { //"aab"
        //edge case
        if (i == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = i + 1; j <= s.length(); ++j) {
            String left = s.substring(i, j);
            if (isPalindromic(left)) {
                list.add(left);
                dfs(s, j, res, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindromic(String s) {
        if (s.isEmpty())
            return true;

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }

        return true;
    }


}
