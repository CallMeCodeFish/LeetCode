package com.imola.leetcode.backtracking;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/7/20 11:48 PM
 */

/**
 * example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 */

class AddAndSearchWordTest {
    public static void main(String[] args) {
        AddAndSearchWord solution = new AddAndSearchWord();
        solution.addWord("bad");
        solution.addWord("dad");
        solution.addWord("mad");
        boolean result = false;
//        result = solution.search("pad");
//        System.out.println(result); //false
//
//        result = solution.search("bad");
//        System.out.println(result); //true

//        result = solution.search(".ad");
//        System.out.println(result); //true

        result = solution.search("b..");
        System.out.println(result); //true
    }
}