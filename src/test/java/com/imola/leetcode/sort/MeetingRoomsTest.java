package com.imola.leetcode.sort;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/6/20 8:00 PM
 */

/**
 * example 1:
 * Input: [[0,30],[5,10],[15,20]]  [[5,8],[6,8]]
 * Output: false
 * <p>
 * example 2:
 * Input: [[7,10],[2,4]]
 * Output: true
 */

class MeetingRoomsTest {
    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();
//        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals = new int[][]{{7, 10}, {2, 4}};
        boolean result = solution.canAttendMeetings(intervals);
        System.out.println(result);
    }
}