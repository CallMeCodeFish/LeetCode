package com.imola.leetcode.bfs;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/4/20 5:10 PM
 */

/**
 * example:
 * <p>
 * before:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * <p>
 * after:
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 */

class WallsAndGatesTest {
    public static void main(String[] args) {
        WallsAndGates solution = new WallsAndGates();
        int INF = Integer.MAX_VALUE;
        int[][] rooms = new int[][]{{INF, -1, 0, INF}, {INF, INF, INF, -1}, {INF, -1, INF, -1}, {0, -1, INF, INF}};
        solution.wallsAndGates(rooms);
        for (int[] room : rooms) {
            System.out.println(Arrays.toString(room));
        }
    }
}