package com.imola.leetcode.design;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/11/20 10:52 PM
 */

/**
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

class DesignSnakeGameTest {
    public static void main(String[] args) {
        int[][] food = new int[][]{{1, 2}, {0, 1}};
        DesignSnakeGame snake = new DesignSnakeGame(3, 2, food);
        System.out.println(snake.move("R")); //0
        System.out.println(snake.move("D")); //0
        System.out.println(snake.move("R")); //1
        System.out.println(snake.move("U")); //1
        System.out.println(snake.move("L")); //2
        System.out.println(snake.move("U")); //-1
    }
}