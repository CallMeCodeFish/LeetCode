package com.imola.leetcode.greedy;

/**
 * @author Heng Yu
 * @date 1/21/20 10:11 AM
 */

/**
 * leetcode 134: Gas Station
 *
 * description: There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station
 * (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1.
 *
 * Note:
 *
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 */

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] net = new int[length];
        for (int i = 0; i < length; ++i) {
            net[i] = gas[i] - cost[i];
        }

        for (int i = 0; i < length; ++i) {
            if (net[i] < 0)
                continue;

            int sum = net[i];
            int j = i + 1;
            boolean isExisted = true;
            while (j % length != i) {
                int k = j % length;
                sum += net[k];
                if (sum < 0) {
                    isExisted = false;
                    break;
                }
                j++;
            }
            if (isExisted)
                return i;
            i = j; // if sum < 0 at index j, indices equal to or less than j cannot be candidate for index i which is the beginning.
        }

        return -1;
    }
}
