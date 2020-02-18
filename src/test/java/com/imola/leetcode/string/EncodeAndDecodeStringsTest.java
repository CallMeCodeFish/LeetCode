package com.imola.leetcode.string;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/18/20 1:06 PM
 */

/**
 * ["Hello","World"]
 */

class EncodeAndDecodeStringsTest {
    public static void main(String[] args) {
        System.out.println();

        EncodeAndDecodeStrings solution = new EncodeAndDecodeStrings();
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        String encodedString = solution.encode(list);
        System.out.println("encodedString: " + encodedString);
        List<String> decodedList = solution.decode(encodedString);
        System.out.println(decodedList);
    }
}