package com.imola.leetcode.bfs;

/**
 * @author Heng Yu
 * @date 2/4/20 4:35 PM
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 286: Walls and Gates
 * <p>
 * description:
 * You are given a m x n 2D grid initialized with these three possible values.
 * <p>
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume
 * that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be
 * filled with INF.
 * <p>
 * example:
 * <p>
 * Given the 2D grid:
 * <p>
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * <p>
 * After running your function, the 2D grid should be:
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 */

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        //edge case
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;

        int rows = rooms.length;
        int cols = rooms[0].length;

        //a queue containing positions that have exact coordination
        Queue<WGPosition> queue = new LinkedList<>();

        //add positions of gate into the queue
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (0 == rooms[i][j]) {
                    queue.offer(new WGPosition(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            WGPosition center = queue.poll();
            int x = center.x;
            int y = center.y;
            //top x-1, y
            if (x - 1 >= 0 && rooms[x - 1][y] > 1 + rooms[x][y]) {
                rooms[x - 1][y] = 1 + rooms[x][y];
                queue.offer(new WGPosition(x - 1, y));
            }

            //bottom x+1, y
            if (x + 1 < rows && rooms[x + 1][y] > 1 + rooms[x][y]) {
                rooms[x + 1][y] = 1 + rooms[x][y];
                queue.offer(new WGPosition(x + 1, y));
            }

            //left x, y-1
            if (y - 1 >= 0 && rooms[x][y - 1] > 1 + rooms[x][y]) {
                rooms[x][y - 1] = 1 + rooms[x][y];
                queue.offer(new WGPosition(x, y - 1));
            }

            //right x, y+1
            if (y + 1 < cols && rooms[x][y + 1] > 1 + rooms[x][y]) {
                rooms[x][y + 1] = 1 + rooms[x][y];
                queue.offer(new WGPosition(x, y + 1));
            }
        }

        //
    }
}

class WGPosition {
    int x;
    int y;

    public WGPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public WGPosition() {
        this.x = 0;
        this.y = 0;
    }
}
