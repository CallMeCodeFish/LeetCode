package com.imola.leetcode.string;

/**
 * @author Heng Yu
 * @date 2/18/20 10:07 AM
 */

/**
 * leetcode 161: One Edit Distance
 *
 * description:
 * Given two strings s and t, determine if they are both one edit distance apart.
 *
 * Note:
 *
 * There are 3 possiblities to satisify one edit distance apart:
 *
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 *
 * example 1:
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 *
 * example 2:
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 *
 * example 3:
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 */

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1)
            return false;

        if (s.isEmpty() && !t.isEmpty() || !s.isEmpty() && t.isEmpty())
            return true;

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int i = 0;
        int j = 0;
        boolean hasDiff = false;
        if (s.length() < t.length()) { //insert
            while (i < s.length()) {
                if (charsS[i] != charsT[j]) {
                    if (!hasDiff) {
                        hasDiff = true;
                        ++j;
                    } else {
                        return false;
                    }
                } else {
                    ++i;
                    ++j;
                }
            }
        } else if (s.length() > t.length()) { //delete
            while (j < t.length()) {
                if (charsS[i] != charsT[j]) {
                    if (!hasDiff) {
                        hasDiff = true;
                        ++i;
                    } else {
                        return false;
                    }
                } else {
                    ++i;
                    ++j;
                }
            }
        } else { //replace
            while (i < s.length()) {
                if (charsS[i] != charsT[j]) {
                    if (!hasDiff) {
                        hasDiff = true;
                    } else {
                        return false;
                    }
                }
                ++i;
                ++j;
            }
            if (!hasDiff)
                return false;
        }
        return true;
    }
}
