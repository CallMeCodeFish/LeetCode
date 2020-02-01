package com.imola.oa.netflix;

/**
 * @author Heng Yu
 * @date 1/28/20 8:37 PM
 */


public class ReverseCoin {
    public int solution(int[] A) {
        //edge case
        if (A == null || A.length == 0)
            return 0;

        int zero = 0;
        int one = 0;
        for (int i : A) {
            int tempZero = zero;
            int tempOne = one;
            if (i == 0) {
                zero = tempOne;
                one = tempZero + 1;
            } else {
                zero = tempOne + 1;
                one = tempZero;
            }
        }
        return Math.min(zero, one);
    }
}
