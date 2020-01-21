package com.imola.leetcode.slidingwindow;

/**
 * @author Heng Yu
 * @date 1/20/20 4:47 PM
 */

/**
 * leetcode 424: Longest Repeating Character Replacement
 *
 * description: Given a string s that consists of only uppercase English letters, you can perform at most k operations
 * on that string.
 *
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 *
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above
 * operations.
 *
 * Note:
 * Both the string's length and k will not exceed 104.
 */

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        //edge case
        if (s == null)
            return 0;

        if (s.length() <= k)
            return s.length();

        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        int res = 0;
        int maxChar = -1;
        int maxCount = 0;
        int left = 0;
        int right = 0;
        int n = chars.length;

        while (right < n) {
            int charIndex = chars[right] - 'A';
            int curCount = ++counts[charIndex];
            if (curCount > maxCount) {
                maxCount = curCount;
                maxChar = charIndex;
            }
            int length = right - left + 1;
            if (length <= maxCount + k) {
                res = Math.max(res, length);
            } else { //moving left pointer forward
                while (length > maxCount + k) {
                    int deletedChar = chars[left] - 'A';
                    ++left;
                    --counts[deletedChar];
                    if (deletedChar != maxChar) {
                        break;
                    } else {
                        --length;
                        maxChar = -1;
                        maxCount = 0;
                        for (int i = 0; i < counts.length; i++) {
                            if (counts[i] > maxCount) {
                                maxCount = counts[i];
                                maxChar = i;
                            }
                        }
                    }
                }
            }
            ++right;
        }

        return res;
    }
}
