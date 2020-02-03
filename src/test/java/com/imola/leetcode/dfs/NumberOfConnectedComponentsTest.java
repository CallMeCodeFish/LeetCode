package com.imola.leetcode.dfs;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/3/20 10:49 AM
 */

/**
 * example 1:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 * <p>
 * 0          3
 * |          |
 * 1 --- 2    4
 * <p>
 * Output: 2
 * <p>
 * example 2:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * <p>
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * <p>
 * Output:  1
 */

class NumberOfConnectedComponentsTest {
    public static void main(String[] args) {
        NumberOfConnectedComponents solution = new NumberOfConnectedComponents();
//        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int result = solution.countComponents(5, edges);
        System.out.println(result);
    }
}