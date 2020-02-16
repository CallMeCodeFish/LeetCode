package com.imola.leetcode.array;

/**
 * @author Heng Yu
 * @date 2/15/20 8:08 PM
 */

/**
 * leetcode 370: Range Addition
 *
 * description:
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 *
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray
 * A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 *
 * Return the modified array after all k operations were executed.
 *
 * example:
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * Output: [-2,0,3,5,3]
 *
 * explanation:
 * Initial state:
 * [0,0,0,0,0]
 *
 * After applying operation [1,3,2]:
 * [0,2,2,2,0]
 *
 * After applying operation [2,4,3]:
 * [0,2,5,5,3]
 *
 * After applying operation [0,2,-2]:
 * [-2,0,3,5,3]
 */

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            for (int i = start; i <= end; ++i) {
                res[i] += inc;
            }
        }
        return res;
    }

    /**
     * reference https://segmentfault.com/a/1190000005948569
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray2(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            res[start] += inc;
            if (end + 1 < length) {
                res[end + 1] -= inc;
            }
        }

        for (int i = 1; i < length; ++i) {
            res[i] += res[i - 1];
        }

        return res;
    }
}
