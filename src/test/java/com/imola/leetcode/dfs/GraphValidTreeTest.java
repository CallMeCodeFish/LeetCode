package com.imola.leetcode.dfs;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/2/20 9:21 PM
 */

/**
 * example 1:
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * <p>
 * example 2:
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 */

class GraphValidTreeTest {
    public static void main(String[] args) {
        GraphValidTree solution = new GraphValidTree();
        int[][] edges = new int[][]{{2, 0}, {2, 1}};
//        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        boolean result = solution.validTree(3, edges);
        System.out.println(result);
    }
}