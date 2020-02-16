package com.imola.leetcode.array;

/**
 * @author Heng Yu
 * @date 2/15/20 4:35 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 163: Missing Ranges
 *
 * description:
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return
 * its missing ranges.
 *
 * example:
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        //edge case
        if (lower > upper)
            return res;

        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                res.add(String.valueOf(lower));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(lower);
                sb.append("->");
                sb.append(upper);
                res.add(sb.toString());
            }
            return res;
        }

        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (num < lower) {
                continue;
            } else if (num > upper) {
                break;
            } else { // lower <= num <= upper
                if (num == lower) {
                    ++lower;
                } else {
                    int preNum = num - 1;
                    if (lower == preNum) {
                        res.add(String.valueOf(lower));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(lower);
                        sb.append("->");
                        sb.append(preNum);
                        res.add(sb.toString());
                    }
                    lower = num + 1;
                    if (lower == Integer.MIN_VALUE)
                        break;
                }
            }
        }
        if (lower < upper && lower != Integer.MIN_VALUE) {
            StringBuilder sb = new StringBuilder();
            sb.append(lower);
            sb.append("->");
            sb.append(upper);
            res.add(sb.toString());
        } else if (lower == upper) {
            res.add(String.valueOf(lower));
        }
        return res;
    }
}
