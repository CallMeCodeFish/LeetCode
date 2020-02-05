package com.imola.leetcode.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heng Yu
 * @date 2/4/20 2:00 PM
 */

/**
 * example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
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

class WordLadderTest {
    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = new String[]{"hot","dot","dog","lot","log"};
        List<String> wordList = Arrays.asList(words);
        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}