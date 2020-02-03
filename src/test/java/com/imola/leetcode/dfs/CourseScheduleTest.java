package com.imola.leetcode.dfs;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/2/20 6:22 PM
 */


class CourseScheduleTest {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 0}};
        CourseSchedule solution = new CourseSchedule();
        boolean result = solution.canFinish(2, prerequisites);
        System.out.println(result);
    }
}