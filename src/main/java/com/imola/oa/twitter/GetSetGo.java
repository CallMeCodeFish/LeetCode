package com.imola.oa.twitter;

import java.util.List;

/**
 * @author Heng Yu
 * @date 1/19/20 6:02 PM
 */
public class GetSetGo {
    public static boolean isPossible(List<Integer> calCounts, int requiredCals) {
        // Write your code here
        return helper(calCounts, 0, requiredCals);
    }

    private static boolean helper(List<Integer> calCounts, int begin, int target) {
        int size = calCounts.size();
        if (target == 0) return true;

        if (begin >= size) return false;

        if (target < 0) return false;

        int num = calCounts.get(begin);
        return helper(calCounts, begin + 1, target - num) || helper(calCounts, begin + 1, target);
    }
}
