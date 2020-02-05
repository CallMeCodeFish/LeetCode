package com.imola.leetcode.bfs;

/**
 * @author Heng Yu
 * @date 2/4/20 5:27 PM
 */

import java.util.*;

/**
 * leetcode 310: Minimum Height Trees
 *
 * description:
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a
 * rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 *
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of
 * undirected edges (each edge is a pair of labels).
 *
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same
 * as [1, 0] and thus will not appear together in edges.
 *
 * example 1:
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * Output: [1]
 *
 * example 2:
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * Output: [3, 4]
 */


/**
 * 解法: https://segmentfault.com/a/1190000017095711
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //edge case
        if (1 == n) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }

        //adjacency matrix
        Set<Integer>[] matrix = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            matrix[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            matrix[first].add(second);
            matrix[second].add(first);
        }

        //queue for leaf nodes
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (matrix[i].size() == 1)
                leaves.add(i);
        }

        while (n > 2) {
            int size = leaves.size();
            n -= size;
            for (int i = 0; i < size; ++i) {
                int leaf = leaves.poll();
                //delete edges corresponding to this leaf
                for (int next : matrix[leaf]) {
                    matrix[next].remove(leaf);
                    if (matrix[next].size() == 1)
                        leaves.offer(next);
                }
            }
        }
        return new ArrayList<>(leaves);
    }
}
