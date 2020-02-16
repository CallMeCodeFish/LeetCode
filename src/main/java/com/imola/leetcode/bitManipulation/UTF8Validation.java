package com.imola.leetcode.bitManipulation;

/**
 * @author Heng Yu
 * @date 2/15/20 1:00 AM
 */

/**
 * leetcode 393: UTF-8 Validation
 *
 * description:
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 *
 * For 1-byte character, the first bit is a 0, followed by its unicode code.
 * For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most
 * significant 2 bits being 10.
 * This is how the UTF-8 encoding would work:
 *
 * Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 *
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
 *
 * Note:
 * The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data.
 * This means each integer represents only 1 byte of data.
 *
 * example 1:
 * data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
 *
 * Return true.
 * It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
 *
 * example 2:
 * data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
 *
 * Return false.
 * The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
 * The next byte is a continuation byte which starts with 10 and that's correct.
 * But the second continuation byte does not start with 10, so it is invalid.
 */

public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0)
            return false;
        int i = 0;
        while (i < data.length) {
            int first = data[i];
            if (first <= 0b01111111) { //1 byte 0xxxxxxx
                ++i;
            } else if (0b11000000 <= first && first <= 0b11011111) { //2 bytes 110xxxxx
                if (++i == data.length)
                    return false;
                int num = data[i];
                if (num < 0b10000000 || 0b10111111 < num) {
                    return false;
                }
                ++i;
            } else if (0b11100000 <= first && first <= 0b11101111) { //3 bytes 1110xxxx
                int count = 0;
                while (++i < data.length) {
                    int num = data[i];
                    if (num < 0b10000000 || 0b10111111 < num) {
                        return false;
                    }
                    if (++count == 2)
                        break;
                }
                if (count < 2)
                    return false;
                ++i;
            } else if (0b11110000 <= first && first <= 0b11110111) { //4 bytes 11110xxx
                int count = 0;
                while (++i < data.length) {
                    int num = data[i];
                    if (num < 0b10000000 || 0b10111111 < num) {
                        return false;
                    }
                    if (++count == 3)
                        break;
                }
                if (count < 3)
                    return false;
                ++i;
            } else {
                return false;
            }
        }
        return true;
    }
}
