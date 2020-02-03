package com.imola.leetcode.dfs;

/**
 * @author Heng Yu
 * @date 2/3/20 10:36 AM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 323: Number of Connected Components in an Undirected Graph
 *
 * description:
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a
 * function to find the number of connected components in an undirected graph.
 *
 * example 1:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 *
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * Output: 2
 *
 * example 2:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 *
 * Output:  1
 *
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the
 * same as [1, 0] and thus will not appear together in edges.
 */

public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        //edge case
        if (edges == null || edges.length == 0)
            return n;

        boolean[] visited = new boolean[n];
        List<Integer>[] adjacency = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adjacency[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjacency[edge[0]].add(edge[1]);
            adjacency[edge[1]].add(edge[0]);
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, visited, adjacency);
                ++res;
            }
        }
        return res;
    }

    private void dfs(int i, boolean[] visited, List<Integer>[] adjacency) {
        //set visited[i] to true
        visited[i] = true;

        //traverse the neighbors of i
        for (int j : adjacency[i]) {
            if (!visited[j]) {
                dfs(j, visited, adjacency);
            }
        }
    }
}
