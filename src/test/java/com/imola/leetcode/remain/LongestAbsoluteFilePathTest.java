package com.imola.leetcode.remain;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/21/20 10:38 PM
 */

/**
 * example:
 * input:  "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * output: 32
 */

class LongestAbsoluteFilePathTest {
    public static void main(String[] args) {
        LongestAbsoluteFilePath solution = new LongestAbsoluteFilePath();
        int result = solution.lengthLongestPath("dir\n\t        file.txt\n\tfile2.txt");
        System.out.println(result);
    }
}