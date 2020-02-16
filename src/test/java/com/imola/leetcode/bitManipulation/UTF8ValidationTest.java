package com.imola.leetcode.bitManipulation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/15/20 12:17 PM
 */

/**
 * example 1:
 * input: data = [197, 130, 1]
 * output: true
 * <p>
 * example 2:
 * input: [235, 140, 4]
 * output: false
 */

class UTF8ValidationTest {
    public static void main(String[] args) {
        UTF8Validation solution = new UTF8Validation();
        int[] data = new int[]{235, 140, 4};
        boolean result = solution.validUtf8(data);
        System.out.println(result);
    }
}