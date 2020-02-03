package com.imola.leetcode.dfs;

/**
 * @author Heng Yu
 * @date 2/2/20 6:46 PM
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 210 Course Schedule II
 * <p>
 * description:
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
 * expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should
 * take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all
 * courses, return an empty array.
 * <p>
 * example 1:
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So
 * the correct course order is [0,1]
 * <p>
 * example 2:
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses
 * 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3].
 * Another correct ordering is [0,2,1,3] .
 * <p>
 * Note:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a
 * graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        return bfs(numCourses, prerequisites);
        return dfs(numCourses, prerequisites);
    }

    private int[] dfs(int numCourses, int[][] prerequisites) {
        //edge case
        int[] res = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; ++i) {
                res[i] = i;
            }
            return res;
        }

        int[] visited = new int[numCourses]; // 0: not visited; 1: in progress; 2: visited and has no conflict
        List<Integer>[] adjacency = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adjacency[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            int src = pre[0];
            int dst = pre[1];
            adjacency[src].add(dst);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (0 == visited[i]) {
                list = helper(i, visited, adjacency, list);
                if (list.size() == 0) {
                    return new int[0];
                }
            }
        }

        for (int i = 0; i < numCourses; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    private List<Integer> helper(int i, int[] visited, List<Integer>[] adjacency, List<Integer> list) {
        //set visited[i] to 1, which means in progress
        visited[i] = 1;

        //check its prerequisites
        for (int pre : adjacency[i]) {
            if (1 == visited[pre]) {
                return new ArrayList<>();
            } else if (0 == visited[pre]) {
                list = helper(pre, visited, adjacency, list);
                if (list.size() == 0) {
                    return new ArrayList<>();
                }
            }
        }

        //set visited[i] to 2, which means visited and no conflict
        list.add(i);
        visited[i] = 2;
        return list;
    }

    private int[] bfs(int numCourses, int[][] prerequisites) {
        //edge case
        int[] res = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; ++i) {
                res[i] = i;
            }
            return res;
        }

        int[] outDegree = new int[numCourses];
        List<Integer>[] matrix = new ArrayList[numCourses]; //以每个index为终点的起点列表的array
        for (int i = 0; i < numCourses; ++i) {
            matrix[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            int src = pre[0];
            int dst = pre[1];
            ++outDegree[src];
            matrix[dst].add(src);
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (queue.size() != 0) {
            int dst = queue.poll();
            list.add(dst);
            for (int src : matrix[dst]) {
                --outDegree[src];
                if (outDegree[src] == 0) {
                    queue.offer(src);
                }
            }
        }

        if (numCourses != list.size()) {
            return new int[0];
        }


        for (int i = 0; i < numCourses; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}
