package com.imola.leetcode.string;

/**
 * @author Heng Yu
 * @date 2/18/20 12:53 PM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 271: Encode and Decode Strings
 *
 * description:
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and
 * is decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 *
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 *
 * So Machine 1 does:
 * string encoded_string = encode(strs);
 *
 * and Machine 2 does:
 * vector<string> strs2 = decode(encoded_string);
 *
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 *
 * Note:
 *
 * The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be
 * generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states. Your encode and decode algorithms should be
 * stateless.
 * Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode
 * algorithm.
 */

public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) { //["",""]
        if (strs == null || strs.isEmpty())
            return Character.toString((char)258);

        StringBuilder sb = new StringBuilder();
        boolean hasDelimiter = false;
        for (String str : strs) {
            if (hasDelimiter) {
                sb.append((char) 257);
            } else {
                hasDelimiter = true;
            }
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<>();
        if (s.equals(Character.toString((char) 258)))
            return ret;

        String[] splits = s.split(Character.toString((char) 257), -1);
        ret.addAll(Arrays.asList(splits));
        return ret;
    }
}
