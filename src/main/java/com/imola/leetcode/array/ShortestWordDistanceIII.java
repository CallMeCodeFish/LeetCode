package com.imola.leetcode.array;

/**
 * @author Heng Yu
 * @date 2/15/20 6:11 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 245: Shortest Word Distance III
 *
 * description:
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 * example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “makes”, word2 = “coding”
 * Output: 1
 *
 * Input: word1 = "makes", word2 = "makes"
 * Output: 3
 *
 * Note:
 * You may assume word1 and word2 are both in the list.
 */

public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        Map<String, List<Integer>> map = new HashMap<>();
        map.put(word1, new ArrayList<>());
        if (!map.containsKey(word2))
            map.put(word2, new ArrayList<>());

        for (int i = 0; i < words.length; ++i) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            }
        }

        if (map.size() == 1) { //word1 is the same as word2
            List<Integer> indices = map.get(word1);
            for (int i = 0; i < indices.size() - 1; ++i) {
                res = Math.min(res, indices.get(i + 1) - indices.get(i));
            }
        } else {
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
        }
        return res;
    }
}
