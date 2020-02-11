package com.imola.leetcode.design;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/10/20 10:21 PM
 */

/**
 * example:
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 * <p>
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 */

class Flatten2DVectorTest {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {3}, {4}};
        Flatten2DVector iterator = new Flatten2DVector(nums);
        System.out.println(iterator.next()); //return 1;
        System.out.println(iterator.next()); //return 2;
        System.out.println(iterator.next()); //return 3;
        System.out.println(iterator.hasNext()); //return true;
        System.out.println(iterator.hasNext()); //return true;
        System.out.println(iterator.next()); //return 4
        System.out.println(iterator.hasNext()); //return false;
    }
}