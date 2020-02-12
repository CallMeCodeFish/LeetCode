package com.imola.leetcode.design;

/**
 * @author Heng Yu
 * @date 2/11/20 8:50 PM
 */

/**
 * leetcode 348: Design Tic-Tac-Toe
 * <p>
 * description:
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * <p>
 * You may assume the following rules:
 * <p>
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * <p>
 * example:
 * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
 * <p>
 * TicTacToe toe = new TicTacToe(3);
 * <p>
 * toe.move(0, 0, 1); -> Returns 0 (no one wins)
 * |X| | |
 * | | | |    // Player 1 makes a move at (0, 0).
 * | | | |
 * <p>
 * toe.move(0, 2, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 2 makes a move at (0, 2).
 * | | | |
 * <p>
 * toe.move(2, 2, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 1 makes a move at (2, 2).
 * | | |X|
 * <p>
 * toe.move(1, 1, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 2 makes a move at (1, 1).
 * | | |X|
 * <p>
 * toe.move(2, 0, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 1 makes a move at (2, 0).
 * |X| |X|
 * <p>
 * toe.move(1, 0, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * |O|O| |    // Player 2 makes a move at (1, 0).
 * |X| |X|
 * <p>
 * toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 * |X| |O|
 * |O|O| |    // Player 1 makes a move at (2, 1).
 * |X|X|X|
 * <p>
 * Follow up:
 * Could you do better than O(n2) per move() operation?
 */

public class DesignTicTacToe {
    /**
     * Initialize your data structure here.
     */
    private class WinCondition {
        int player; //identity of player
        boolean canWin; //can still win
        int count; //number of identical chess

        public WinCondition(int player) {
            this.player = player;
            canWin = true;
            count = 1;
        }
    }

    private WinCondition[] h; //horizontal
    private WinCondition[] v; //vertical
    private WinCondition[] d; //diagonal
    private int winner;
    private int size;

    public DesignTicTacToe(int n) {
        this.h = new WinCondition[n];
        this.v = new WinCondition[n];
        this.d = new WinCondition[2];
        this.winner = 0;
        this.size = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        //if there is already a winner, players cannot move any more
        if (winner != 0)
            return winner;

        //horizontal
        if (h[row] == null) {
            h[row] = new WinCondition(player);
        } else {
            if (h[row].canWin) {
                calcWinCondition(h[row], player);
                if (winner != 0)
                    return winner;
            }
        }

        //vertical
        if (v[col] == null) {
            v[col] = new WinCondition(player);
        } else {
            if (v[col].canWin) {
                calcWinCondition(v[col], player);
                if (winner != 0) {
                    return winner;
                }
            }
        }

        //first diagonal
        if (row == col) {
            if (d[0] == null) {
                d[0] = new WinCondition(player);
            } else {
                calcWinCondition(d[0], player);
                if (winner != 0)
                    return winner;
            }
        }

        //second diagonal
        if (row + col == size - 1) {
            if (d[1] == null) {
                d[1] = new WinCondition(player);
            } else {
                calcWinCondition(d[1], player);
                if (winner != 0)
                    return winner;
            }
        }
        return 0;
    }

    private void calcWinCondition(WinCondition wc, int player) {
        if (wc.canWin) {
            if (player == wc.player) {
                ++wc.count;
                if (wc.count == size) {
                    winner = player;
                }
            } else {
                wc.canWin = false;
            }
        }
    }
}
