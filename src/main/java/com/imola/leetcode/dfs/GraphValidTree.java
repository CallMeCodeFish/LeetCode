package com.imola.leetcode.dfs;

/**
 * @author Heng Yu
 * @date 2/2/20 8:39 PM
 */

import java.util.*;

/**
 * leetcode 261: Graph Valid Tree
 *
 * description:
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function
 * to check whether these edges make up a valid tree.
 *
 * example 1:
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 *
 * example 2:
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 *
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the
 * same as [1,0] and thus will not appear together in edges.
 */

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        Set<Integer>[] adjacency = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            adjacency[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjacency[node1].add(node2);
            adjacency[node2].add(node1);
        }

        boolean flag = dfs(0, adjacency, visited);
        if (!flag)
            return false;
        for (int i = 1; i < n; ++i) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    private boolean dfs(int i, Set<Integer>[] adjacency, boolean[] visited) {
        //set visited[i]
        visited[i] = true;

        //traverse the adjacency of i
        for (int j : adjacency[i]) {
            if (visited[j])
                return false;
            adjacency[j].remove(i);
            boolean flag = dfs(j, adjacency, visited);
            if (!flag)
                return false;
        }
        return true;
    }


}
/**
 * 并查集(union find)的解释：https://blog.csdn.net/qq_41593380/article/details/81146850
 */
class GraphValidTree1 {
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        for(int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if(x == y) return false;
            nums[x] = y;
        }
        return edges.length == n - 1;
    }

    private int find(int[] nums, int i) {
        if(nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}
