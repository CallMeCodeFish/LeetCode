package com.imola.leetcode.dfs;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/1/20 10:33 PM
 */

/**
 * example:
 * input
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * <p>
 * output
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */

class SurroundedRegionsTest {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        SurroundedRegions solution = new SurroundedRegions();
        solution.solve(board);
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}