package com.imola.leetcode.dfs;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/2/20 8:31 PM
 */


class CourseScheduleIITest {
    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();
        int[][] nums = new int[][]{{0, 1}};
        int[] result = solution.findOrder(2, nums);
        System.out.println(Arrays.toString(result));
    }
}