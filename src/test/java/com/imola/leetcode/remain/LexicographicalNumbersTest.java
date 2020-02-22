package com.imola.leetcode.remain;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/21/20 9:23 PM
 */


class LexicographicalNumbersTest {
    public static void main(String[] args) {
        LexicographicalNumbers solution = new LexicographicalNumbers();
        List<Integer> result = solution.lexicalOrder(100);
        System.out.println(result);
        System.out.println(result.size());
    }
}