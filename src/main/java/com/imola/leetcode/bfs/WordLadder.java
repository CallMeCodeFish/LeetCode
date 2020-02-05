package com.imola.leetcode.bfs;

/**
 * @author Heng Yu
 * @date 2/4/20 1:10 PM
 */

import java.util.*;

/**
 * leetcode 127: Word Ladder
 * <p>
 * description:
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 * <p>
 * 1. Only one letter can be changed at a time.
 * 2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * <p>
 * example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

/**
 * 由于这个题相当于是要找最短路径，因此要用bfs而不是dfs，dfs侧重与输出全部的结果，但是如果像本题一样，只研究存在性或者最短
 * ，那么使用bfs。此外，建立visited表，防止wordList中的单词被重复使用
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> patterns = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); ++i) {
                String pattern = word.substring(0, i) +
                        "-" +
                        word.substring(i + 1, word.length());
                if (!patterns.containsKey(pattern)) {
                    patterns.put(pattern, new ArrayList<>());
                }
                patterns.get(pattern).add(word);
            }
        }
        //queue and visited set
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        //start bfs
        int res = 0;

        while (!queue.isEmpty()) {
            ++res;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); ++j) {
                    String pattern = word.substring(0, j) + "-" + word.substring(j + 1, word.length());
                    if (patterns.containsKey(pattern)) {
                        List<String> newWords = patterns.get(pattern);
                        for (String newWord : newWords) {
                            if (endWord.equals(newWord)) {
                                return res + 1;
                            }
                            if (!visited.contains(newWord)) {
                                visited.add(newWord);
                                queue.offer(newWord);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
