package com.imola.leetcode.design;

/**
 * @author Heng Yu
 * @date 2/10/20 11:24 PM
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 346: Moving Average from Data Stream
 *
 * description:
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * example:
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */

public class MovingAverage {
    /** Initialize your data structure here. */
    private Queue<Integer> queue;
    private long sum;
    private int capacity;

    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.capacity = size;
        this.sum = 0;
    }

    public double next(int val) {
        if (capacity == 0)
            return 0.0;

        if (queue.size() == capacity) {
            sum -= (long) queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum * 1.0 / queue.size();
    }
}
