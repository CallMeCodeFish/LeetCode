package com.imola.leetcode.binarysearch;

/**
 * @author Heng Yu
 * @date 2/4/20 10:52 AM
 * <p>
 * leetcode 378: Kth Smallest Element in a Sorted Matrix
 * <p>
 * description:
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest
 * element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * example:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 * <p>
 * leetcode 378: Kth Smallest Element in a Sorted Matrix
 * <p>
 * description:
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest
 * element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * example:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 * <p>
 * leetcode 378: Kth Smallest Element in a Sorted Matrix
 * <p>
 * description:
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest
 * element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * example:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */

/**
 * leetcode 378: Kth Smallest Element in a Sorted Matrix
 *
 * description:
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest
 * element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * example:
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://segmentfault.com/a/1190000018155081
 * 两种不同的解法:
 * 1. priority queue
 *
 * 2. binary search
 */
public class KthSmallestElement {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //将每行的第一个元素加入到优先级队列
        Queue<MatrixElement> queue = new PriorityQueue<>();
        for (int i = 0; i < rows; ++i) {
            queue.offer(new MatrixElement(i, 0, matrix[i][0]));
        }

        //poll k-1次，然后将poll出的元素的行内下个元素offer到heap中
        for (int i = 0; i < k - 1; ++i) {
            MatrixElement cur = queue.poll();
            if (cur.y + 1 < cols) {
                queue.offer(new MatrixElement(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
            }
        }

        //poll得到结果
        return queue.poll().value;
    }

    //binary search方法容易出错，=的影响巨大
    public int myKthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int min = matrix[0][0]; //minimum value
        int max = matrix[rows - 1][cols - 1];
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            int i = rows - 1, j = 0;
            while (i >= 0 && j < cols) {
                if (matrix[i][j] <= mid) {
                    count += i + 1;
                    ++j;
                } else {
                    --i;
                }
            }
            if (count < k)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return min;
    }
}

class MatrixElement implements Comparable {
    int x; //x coordination
    int y; //y coordination
    int value;

    public MatrixElement(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        MatrixElement me = (MatrixElement) o;
        return this.value - me.value;
    }
}
