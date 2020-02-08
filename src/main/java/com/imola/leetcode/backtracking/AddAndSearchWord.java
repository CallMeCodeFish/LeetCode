package com.imola.leetcode.backtracking;

/**
 * @author Heng Yu
 * @date 2/7/20 11:03 PM
 */

import java.util.*;

/**
 * leetcode 211: Add and Search Word - Data structure design
 *
 * description:
 * Design a data structure that supports the following two operations:
 *  void addWord(word)
 *  bool search(word)
 *
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means
 * it can represent any one letter.
 *
 * example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */

public class AddAndSearchWord {
    private Map<Integer, Set<String>> dict;

    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        dict = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int length = word.length();
        if (!dict.containsKey(length)) {
            dict.put(length, new HashSet<>());
        }
        dict.get(length).add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) { //".ad"
        int length = word.length();
        if (!dict.containsKey(length))
            return false;

        Set<String> words = dict.get(length);
        List<ValidSubString> subStrings = getSubStrings(word);

        for (String cached : words) {
            boolean canFind = true;
            for (ValidSubString sub : subStrings) {
                int start = sub.start;
                int end = sub.end;
                if (!cached.substring(start, end).equals(sub.content)) {
                    canFind = false;
                    break;
                }
            }
            if (canFind)
                return true;
        }
        return false;
    }

    private List<ValidSubString> getSubStrings(String word) { // ".ad"
        List<ValidSubString> res = new ArrayList<>();
        int i = 0;
        while (i < word.length()) {
            if ('.' == word.charAt(i)) {
                ++i;
                continue;
            }
            int j = i + 1;
            while (j < word.length()) {
                if ('.' == word.charAt(j))
                    break;
                ++j;
            }
            res.add(new ValidSubString(i, j, word.substring(i, j)));
            i = j;
        }
        return res;
    }

    private class ValidSubString {
        private int start;
        private int end;
        private String content;

        public ValidSubString(int start, int end, String content) {
            this.start = start;
            this.end = end;
            this.content = content;
        }
    }
}
