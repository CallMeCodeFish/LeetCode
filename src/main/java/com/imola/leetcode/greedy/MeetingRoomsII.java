package com.imola.leetcode.greedy;

/**
 * @author Heng Yu
 * @date 1/21/20 11:38 AM
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 253: Meeting Rooms II
 *
 * description: Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), find the minimum number of conference rooms required.
 */

public class MeetingRoomsII {
    public int MyMinMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        int length = intervals.length;
        Interval[] ar_intervals = new Interval[length];
        for (int i = 0; i < length; ++i) {
            int[] interval = intervals[i];
            ar_intervals[i] = new Interval(interval[0], interval[1]);
        }

        Arrays.sort(ar_intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.left - o2.left;
            }
        });

        PriorityQueue<Interval> heap = new PriorityQueue<>(length, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.right - o2.right;
            }
        });

        heap.offer(ar_intervals[0]);

        for (int i = 1; i < length; ++i) {
            Interval top = heap.poll();
            if (ar_intervals[i].left >= top.right) {
                top.right = ar_intervals[i].right;
            } else {
                heap.offer(ar_intervals[i]);
            }
            heap.offer(top);
        }

        return heap.size();
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        int length = intervals.length;
        int[] starts = new int[length];
        int[] ends = new int[length];
        for (int i = 0; i < length; ++i) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int j = 0;
        int res = 0;
        for (int i = 0; i < length; ++i) {
            if (starts[i] < ends[j]) {
                res++;
            } else {
                j++;
            }
        }
        return res;
    }
}

class Interval {
    int left;
    int right;

    public Interval() {
        left = 0;
        right = 0;
    }

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
