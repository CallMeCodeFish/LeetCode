package com.imola.oa.netflix;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/28/20 8:50 PM
 */


class ReverseCoinTest {
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 1, 0};
        ReverseCoin solution = new ReverseCoin();
        int result = solution.solution(A);
        System.out.println(result);
    }

}