package com.imola.leetcode.sort;

/**
 * @author Heng Yu
 * @date 2/6/20 10:08 AM
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 179: Largest Number
 * <p>
 * description:
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * example 1:
 * Input: [10,2]
 * Output: "210"
 * <p>
 * example 2:
 * Input: [3,30,34,5,9]  [30,30333] -> 343305301
 * Output: "9534330"
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */

public class LargestNumber {
    public String largestNumber(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0)
            return "";

        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            str[i] = String.valueOf(nums[i]);
        }

        //runtime不是特别好但是逻辑简单
        Arrays.sort(str, new Comparator<String>() { //[121,12]
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(0) < o2.charAt(0)) {
                    return 1;
                } else if (o1.charAt(0) > o2.charAt(0)) {
                    return -1;
                } else {
                    return (o2 + o1).compareTo(o1 + o2);
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }

        int start = sb.length();
        for (int i = 0; i < sb.length(); ++i) {
            char c = sb.charAt(i);
            if ('0' != c) {
                start = i;
                break;
            }
        }
        if (start == sb.length())
            return "0";

        return sb.substring(start);
    }
}
