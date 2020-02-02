package com.imola.leetcode.dfs;

/**
 * @author Heng Yu
 * @date 2/1/20 9:33 PM
 */

/**
 * leetcode 130: Surrounded Regions
 * <p>
 * description:
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * <p>
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * <p>
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped
 * to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */

public class SurroundedRegions {
    public void solve(char[][] board) {
        //edge case
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        //boolean[] visited
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] preCheck = new boolean[rows][cols]; //
        boolean[][] visited = new boolean[rows][cols]; //default: false

        //traverse each element in the board matrix
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if ('O' == board[i][j] && !visited[i][j]) {
                    if (hasBorder(board, preCheck, i, j)) {
                        //update visited
                        dfs(board, visited, i, j, false);
                    } else {
                        //flip and visited
                        dfs(board, visited, i, j, true);
                    }
                }
            }
        }
    }

    private boolean hasBorder(char[][] board, boolean[][] preCheck, int i, int j) {
        preCheck[i][j] = true;

        //i,j itself
        if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)
            return true;

        //top
        boolean res = false;
        if (i - 1 >= 0 && 'O' == board[i - 1][j] && !preCheck[i - 1][j]) {
            res = hasBorder(board, preCheck, i - 1, j);
        }
        if (res)
            return true;

        //bottom
        if (i + 1 < board.length && 'O' == board[i + 1][j] && !preCheck[i + 1][j]) {
            res = hasBorder(board, preCheck, i + 1, j);
        }
        if (res)
            return true;

        //left
        if (j - 1 >= 0 && 'O' == board[i][j - 1] && !preCheck[i][j - 1]) {
            res = hasBorder(board, preCheck, i, j - 1);
        }
        if (res)
            return true;

        //right
        if (j + 1 < board[0].length && 'O' == board[i][j + 1] && !preCheck[i][j + 1]) {
            res = hasBorder(board, preCheck, i, j + 1);
        }
        return res;
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, boolean flip) {
        if (flip)
            board[i][j] = 'X';

        visited[i][j] = true;

        //top i-1,j
        if (i - 1 >= 0 && 'O' == board[i - 1][j] && !visited[i - 1][j]) {
            dfs(board, visited, i - 1, j, flip);
        }

        //bottom i+1,j
        if (i + 1 < board.length && 'O' == board[i + 1][j] && !visited[i + 1][j]) {
            dfs(board, visited, i + 1, j, flip);
        }

        //left i,j-1
        if (j - 1 >= 0 && 'O' == board[i][j - 1] && !visited[i][j - 1]) {
            dfs(board, visited, i, j - 1, flip);
        }

        //right i,j+1
        if (j + 1 < board[0].length && 'O' == board[i][j + 1] && !visited[i][j + 1]) {
            dfs(board, visited, i, j + 1, flip);
        }
    }
}

//leetcode 1ms solution
/**
 * 1. 找出border上的'O'并标记它和与它连通的所有邻居，标记成'#'
 * 2. 遍历board，将'#'改成'O'，其他改成'X'
 */
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') return;
        board[row][col] = '#';
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
    }
}
