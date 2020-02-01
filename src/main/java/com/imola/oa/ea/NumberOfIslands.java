package com.imola.oa.ea;

/**
 * @author Heng Yu
 * @date 1/31/20 7:49 PM
 */

/**
 * leetcode 200 Number of islands
 *
 * description:
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 *
 * example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 *
 * example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        //edge case
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int res = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if ('1' == grid[i][j] && !visited[i][j]) {
                    //find neighbors
                    helper(grid, visited, i, j);
                    ++res;
                }
            }
        }

        return res;
    }

    private void helper(char[][] grid, boolean[][] visited, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited[i][j] = true;
        //top i - 1, j
        if (i - 1 >= 0 && '1' == grid[i - 1][j] && !visited[i - 1][j]) {
            helper(grid, visited, i - 1, j);
        }

        //bottom i + 1, j
        if (i + 1 < rows && '1' == grid[i + 1][j] && !visited[i + 1][j]) {
            helper(grid, visited, i + 1, j);
        }

        //left i, j - 1
        if (j - 1 >= 0 && '1' == grid[i][j - 1] && !visited[i][j - 1]) {
            helper(grid, visited, i, j - 1);
        }

        //right i, j + 1
        if (j + 1 < cols && '1' == grid[i][j + 1] && !visited[i][j + 1]) {
            helper(grid, visited, i, j + 1);
        }
    }
}
