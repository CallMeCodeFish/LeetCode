package com.imola.leetcode.remain;

/**
 * @author Heng Yu
 * @date 2/22/20 10:27 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 395: Longest Substring with At Least K Repeating Characters
 *
 * description:
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every
 * character in T appears no less than k times.
 *
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
 * "dababc"
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */

public class LongestSubstringWithKRepeating {
    public int longestSubstring(String s, int k) {
        //edge case
        if (s == null || s.length() == 0)
            return 0;

        if (k <= 1)
            return s.length();

        int maxLength = 0;
        for (int n = 1; n <= 26; ++n) {
            int[] alphabet = new int[26];
            int count = 0;
            int i = 0;
            int j = 0;
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (alphabet[ch - 'a'] == 0) {
                    ++count;
                    while (count > n) {
                        int leftCharIndex = s.charAt(i) - 'a';
                        --alphabet[leftCharIndex];
                        if (alphabet[leftCharIndex] == 0) {
                            --count;
                        }
                        ++i;
                    }
                }
                ++alphabet[ch - 'a'];
                boolean hasRepeat = true;
                int length = 0;
                for (int idx = 0; idx < alphabet.length; ++idx) {
                    if (alphabet[idx] > 0 && alphabet[idx] < k) {
                        hasRepeat = false;
                        break;
                    } else if (alphabet[idx] >= k) {
                        length += alphabet[idx];
                    }
                }
                if (hasRepeat) {
                    maxLength = Math.max(maxLength, length);
                }
                ++j;
            }
        }
        return maxLength;
    }

    /**
     * reference: 0 ms answer
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring2(String s, int k) {
        return dfs(s, k);
    }

    private int dfs(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++alphabet[s.charAt(i) - 'a'];
        }
        boolean flag = true;
        for (int i = 0; i < alphabet.length; ++i) {
            if (0 < alphabet[i] && alphabet[i] < k) {
                flag = false;
                break;
            }
        }
        if (flag)
            return s.length();
        int start = 0;
        int end = 0;
        int res = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (alphabet[ch - 'a'] < k) {
                int length = dfs(s.substring(start, end), k);
                res = Math.max(res, length);
                start = end + 1;
            }
            ++end;
        }
        int length = dfs(s.substring(start), k);
        res = Math.max(res, length);
        return res;
    }
}
