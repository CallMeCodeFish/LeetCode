package com.imola.leetcode.design;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/9/20 10:07 PM
 */

/**
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 */

class ImplementTrieTest {
    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); //true
        System.out.println(trie.search("app")); //false
        System.out.println(trie.startsWith("app")); //true
        trie.insert("app");
        System.out.println(trie.search("app")); //true
    }
}