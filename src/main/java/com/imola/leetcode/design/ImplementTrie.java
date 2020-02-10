package com.imola.leetcode.design;

/**
 * @author Heng Yu
 * @date 2/9/20 9:31 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 208: Implement Trie (Prefix Tree)
 *
 * description:
 * Implement a trie with insert, search, and startsWith methods.
 *
 * example:
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */

public class ImplementTrie {
    private class TrieNode {
        char val;
        boolean isLeaf;
        Map<Character, TrieNode> children;

        public TrieNode(char val) {
            this.val = val;
            this.isLeaf = false;
            this.children = new HashMap<>();
        }

        public TrieNode() {
            this.val = '\0';
            this.isLeaf = false;
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode(ch));
            }
            cur = cur.children.get(ch);
        }
        cur.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch))
                return false;
            cur = cur.children.get(ch);
        }
        return cur.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            if (!cur.children.containsKey(ch))
                return false;
            cur = cur.children.get(ch);
        }
        return true;
    }
}
