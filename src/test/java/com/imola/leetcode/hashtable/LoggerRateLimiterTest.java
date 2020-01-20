package com.imola.leetcode.hashtable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/20/20 3:59 PM
 */

/**
 * example:
 *
 * Logger logger = new Logger();
 *
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;
 *
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 *
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 *
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 *
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 *
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 */

class LoggerRateLimiterTest {
    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();
        boolean log1 = logger.shouldPrintMessage(1, "foo");//true
        System.out.println("log1: " + log1);

        boolean log2 = logger.shouldPrintMessage(2, "bar");//true
        System.out.println("log2: " + log2);

        boolean log3 = logger.shouldPrintMessage(3, "foo"); //false
        System.out.println("log3: " + log3);

        boolean log4 = logger.shouldPrintMessage(8, "bar");//false
        System.out.println("log4: " + log4);

        boolean log5 = logger.shouldPrintMessage(10, "foo");//false
        System.out.println("log5: " + log5);

        boolean log6 = logger.shouldPrintMessage(11, "foo");//true
        System.out.println("log6: " + log6);
    }
}