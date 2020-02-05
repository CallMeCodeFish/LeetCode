package com.imola.leetcode.bfs;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/4/20 7:02 PM
 */

/**
 * example 1:
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * <p>
 * Output: [1]
 * <p>
 * example 2:
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * <p>
 * Output: [3, 4]
 */


class MinimumHeightTreesTest {
    public static void main(String[] args) {
        MinimumHeightTrees solution = new MinimumHeightTrees();
        int[][] edges = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
//        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        List<Integer> result = solution.findMinHeightTrees(6, edges);
        System.out.println(result);
    }
}