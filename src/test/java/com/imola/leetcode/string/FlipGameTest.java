package com.imola.leetcode.string;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/18/20 2:02 PM
 */


class FlipGameTest {
    public static void main(String[] args) {
        FlipGame solution = new FlipGame();
        List<String> result = solution.generatePossibleNextMoves("++++");
        System.out.println(result);
    }
}