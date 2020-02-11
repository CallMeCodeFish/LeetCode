package com.imola.leetcode.design;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/10/20 11:35 PM
 */

/**
 * example:
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */

class MovingAverageTest {
    public static void main(String[] args) {
        MovingAverage solution = new MovingAverage(0);
        System.out.println(solution.next(1)); //return 1;
        System.out.println(solution.next(10)); //return 5.5
        System.out.println(solution.next(3)); //return 14/3
        System.out.println(solution.next(5)); //return 6
    }
}