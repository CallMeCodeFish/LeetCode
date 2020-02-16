package com.imola.leetcode.string;

/**
 * @author Heng Yu
 * @date 2/15/20 9:03 PM
 */

import java.util.Arrays;

/**
 * leetcode 157: Read N Characters Given Read4
 *
 * example 1:
 * Input: file = "abc", n = 4
 * Output: 3
 * Explanation: After calling your read method, buf should contain "abc". We read a total of 3 characters from the
 * file, so return 3. Note that "abc" is the file's content, not buf. buf is the destination buffer that you will
 * have to write the results to.
 *
 * example 2:
 * Input: file = "abcde", n = 5
 * Output: 5
 * Explanation: After calling your read method, buf should contain "abcde". We read a total of 5 characters from the
 * file, so return 5.
 *
 * example 3:
 * Input: file = "abcdABCD1234", n = 12
 * Output: 12
 * Explanation: After calling your read method, buf should contain "abcdABCD1234". We read a total of 12 characters
 * from the file, so return 12.
 *
 * example 4:
 * Input: file = "leetcode", n = 5
 * Output: 5
 * Explanation: After calling your read method, buf should contain "leetc". We read a total of 5 characters from
 * the file, so return 5.
 *
 * Note:
 *
 * Consider that you cannot manipulate the file directly, the file is only accesible for read4 but not for read.
 * The read function will only be called once for each test case.
 * You may assume the destination buffer array, buf, is guaranteed to have enough space for storing n characters.
 */

public class ReadNCharacters {
    public int read(char[] buf, int n) {
        int res = 0;
        char[] buf4 = new char[4];
        while (res < n) {
            int count = read4(buf4);
            if (res + count <= n) {
                for (int i = 0; i < count; ++i) {
                    buf[res++] = buf4[i];
                }
            } else {
                int m = n - res;
                for (int i = 0; i < m; ++i) {
                    buf[res++] = buf4[i];
                }
            }
            if (count < 4) {
                break;
            }
        }
        return res;
    }

    private int read4(char[] buf) {
        return 0;
    }
}
