package com.imola.leetcode.dfs;

/**
 * @author Heng Yu
 * @date 2/2/20 12:12 AM
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 207: Course Schedule
 * <p>
 * description:
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
 * expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * example 1:
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * example 2:
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * <p>
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a
 * graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        return bfs(numCourses, prerequisites);
        return dfs(numCourses, prerequisites);
    }

    private boolean bfs(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;

        List<Integer>[] adjacency = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adjacency[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numCourses]; //indegree
        for (int[] prerequisite : prerequisites) {
            int src = prerequisite[0];
            int dst = prerequisite[1];
            adjacency[src].add(dst);
            ++inDegree[dst];
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; ++i) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        while (queue.size() != 0) {
            int src = queue.poll();
            ++count;
            for (int dst : adjacency[src]) {
                --inDegree[dst];
                if (inDegree[dst] == 0) {
                    queue.offer(dst);
                }
            }
        }
        return count == numCourses;
    }

    private boolean dfs(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;

        int[] visited = new int[numCourses]; // 0 -> not visited; 1 -> in progress; 2 -> visited and acyclic
        List<Integer>[] adjacency = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adjacency[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            int src = pre[0];
            int dst = pre[1];
            adjacency[src].add(dst);
        }

        for (int i = 0; i < numCourses; ++i) {
            if (0 == visited[i]) {
                boolean flag = hasCycle(i, visited, adjacency);
                if (flag)
                    return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int course, int[] visited, List<Integer>[] adjacency) {
        //set visited[course] to 1 which means in progress
        visited[course] = 1;

        //for destinations with the source of course, call hasCycle recursively
        for (int pre : adjacency[course]) {
            if (0 == visited[pre]) {
                boolean flag = hasCycle(pre, visited, adjacency);
                if (flag)
                    return true;
            } else if (1 == visited[pre]) {
                return true;
            }
        }

        //if no cycle, set visited[course] to 2 which means safe, and return false
        visited[course] = 2;
        return false;
    }
}
