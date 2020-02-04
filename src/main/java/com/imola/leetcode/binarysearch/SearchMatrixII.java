package com.imola.leetcode.binarysearch;

/**
 * @author Heng Yu
 * @date 2/3/20 7:09 PM
 */

/**
 * leetcode 240: Search a 2D Matrix II
 *
 * description:
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *  Integers in each row are sorted in ascending from left to right.
 *  Integers in each column are sorted in ascending from top to bottom.
 *
 *  example:
 *  [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 */

public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        //edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean res = false;
        for (int i = 0; i < rows; ++i) {
            int min = matrix[i][0]; // maximum value of a row
            int max = matrix[i][cols - 1]; // minimum value of a column
            if (target < min)
                break;
            if (target > max)
                continue;
            //min <= target <= max
            res = binSearch(target, matrix[i]); // use binary search in row i
            if (res)
                break;
        }
        return res;
    }

    private boolean binSearch(int target, int[] row) {
        int left = 0;
        int right = row.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (row[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }

        if (left == 0)
            return false;
        return row[left - 1] == target;
    }
}
