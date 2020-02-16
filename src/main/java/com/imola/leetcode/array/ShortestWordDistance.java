package com.imola.leetcode.array;

/**
 * @author Heng Yu
 * @date 2/15/20 5:28 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 243: Shortest Word Distance
 *
 * description:
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the
 * list.
 *
 * example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 *
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 *
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        Map<String, List<Integer>> map = new HashMap<>(); //hash map for word1 and word2, containing the indices in the array
        map.put(word1, new ArrayList<>());
        map.put(word2, new ArrayList<>());

        for (int i = 0; i < words.length; ++i) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            }
        }

        int i = 0;
        int j = 0;
        List<Integer> indices1 = map.get(word1);
        List<Integer> indices2 = map.get(word2);
        while (i < indices1.size() && j < indices2.size()) {
            int index1 = indices1.get(i);
            int index2 = indices2.get(j);
            if (index1 < index2) {
                res = Math.min(res, index2 - index1);
                ++i;
            } else {
                res = Math.min(res, index1 - index2);
                ++j;
            }
        }
        while (i < indices1.size()) {
            int index1 = indices1.get(i);
            int index2 = indices2.get(j - 1);
            res = Math.min(res, Math.abs(index1 - index2));
            ++i;
        }

        while (j < indices2.size()) {
            int index1 = indices1.get(i - 1);
            int index2 = indices2.get(j);
            res = Math.min(res, Math.abs(index1 - index2));
            ++j;
        }
        return res;
    }
}
