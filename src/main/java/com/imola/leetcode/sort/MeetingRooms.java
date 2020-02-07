package com.imola.leetcode.sort;

/**
 * @author Heng Yu
 * @date 2/6/20 7:38 PM
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 252: Meeting Rooms
 *
 * description:
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * example 1:
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 *
 * example 2:
 * Input: [[7,10],[2,4]]
 * Output: true
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method
 * signature.
 */

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
//        return bySort(intervals);
        return byComparator(intervals);
    }

    private boolean bySort(int[][] intervals) {//sort + two pointers
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int j = 0; //pointer for end time
        int count = 0;
        for (int i = 0; i < start.length; ++i) { //pointer for start time
            if (start[i] < end[j]) {
                ++count;
                if (count > 1)
                    return false;
            } else {
                ++j;
            }
        }
        return true;
    }

    private boolean byComparator(int[][] intervals) {
        MeetingInterval[] meetingIntervals = new MeetingInterval[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            int[] interval = intervals[i];
            meetingIntervals[i] = new MeetingInterval(interval[0], interval[1]);
        }

        Arrays.sort(meetingIntervals, new Comparator<MeetingInterval>() {
            @Override
            public int compare(MeetingInterval o1, MeetingInterval o2) {
                return o1.start - o2.start;
            }
        });

        MeetingInterval res = meetingIntervals[0];
        for (int i = 1; i < meetingIntervals.length; ++i) {
            MeetingInterval meetingInterval = meetingIntervals[i];
            if (meetingInterval.start < res.end)
                return false;
            res.end = meetingInterval.end;
        }
        return true;
    }

    private class MeetingInterval {
        int start;
        int end;

        public MeetingInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
