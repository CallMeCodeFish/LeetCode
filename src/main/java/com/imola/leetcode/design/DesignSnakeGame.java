package com.imola.leetcode.design;

/**
 * @author Heng Yu
 * @date 2/11/20 9:55 PM
 */

import java.util.*;

/**
 * leetcode 353: Design Snake Game
 * <p>
 * description:
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are
 * not familiar with the game.
 * <p>
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 * <p>
 * You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's
 * score both increase by 1.
 * <p>
 * Each food appears one by one on the screen. For example, the second food will not appear until the first food was
 * eaten by the snake.
 * <p>
 * When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 * <p>
 * example:
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].
 * <p>
 * Snake snake = new Snake(width, height, food);
 * <p>
 * Initially the snake appears at position (0,0) and the food at (1,2).
 * <p>
 * |S| | |
 * | | |F|
 * <p>
 * snake.move("R"); -> Returns 0
 * <p>
 * | |S| |
 * | | |F|
 * <p>
 * snake.move("D"); -> Returns 0
 * <p>
 * | | | |
 * | |S|F|
 * <p>
 * snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
 * <p>
 * | |F| |
 * | |S|S|
 * <p>
 * snake.move("U"); -> Returns 1
 * <p>
 * | |F|S|
 * | | |S|
 * <p>
 * snake.move("L"); -> Returns 2 (Snake eats the second food)
 * <p>
 * | |S|S|
 * | | |S|
 * <p>
 * snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */

public class DesignSnakeGame {
    private class SnakeBody {
        int x;
        int y;

        public SnakeBody(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SnakeBody snakeBody = (SnakeBody) o;
            return x == snakeBody.x &&
                    y == snakeBody.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private Queue<SnakeBody> queue;
    private Set<SnakeBody> set;
    private SnakeBody tail;
    private SnakeBody head;
    private int width;
    private int height;
    private int[][] food;
    private int target;
    private int score;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.target = 0;
        this.score = 0;
        this.queue = new LinkedList<>();
        this.set = new HashSet<>();
        this.head = this.tail = new SnakeBody(0, 0);
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int x = head.x;
        int y = head.y;
        if ("U".equals(direction)) { //move upward
            if (--x < 0) //hit top boundary
                return -1;
        } else if ("D".equals(direction)) { //move downward
            if (++x >= height)
                return -1;
        } else if ("L".equals(direction)) { //move left;
            if (--y < 0)
                return -1;
        } else { //move right
            if (++y >= width)
                return -1;
        }
        SnakeBody nextHead = new SnakeBody(x, y);
        if (set.contains(nextHead))
            return -1;
        head = nextHead;
        queue.offer(head);
        set.add(head);

        if (target < food.length && food[target][0] == x && food[target][1] == y) { //eating food ahead
            ++target;
            ++score;
        } else {
            tail = queue.poll();
            set.remove(tail);
        }
        return score;
    }
}
