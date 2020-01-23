package com.imola.leetcode.greedy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/21/20 11:39 AM
 */

/**
 * example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * <p>
 * example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 */

class MeetingRoomsIITest {
    public static void main(String[] args) {
        MeetingRoomsII solution = new MeetingRoomsII();
//        int[][] intervals = new int[][]{{0, 30},{5, 10},{15, 20}};
        int[][] intervals = new int[][]{{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};
        int result = solution.minMeetingRooms(intervals);
        System.out.println(result);
    }
}