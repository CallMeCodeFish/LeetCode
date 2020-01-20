package com.imola.leetcode.hashtable;

/**
 * @author Heng Yu
 * @date 1/20/20 3:58 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 359: Logger Rate Limiter
 *
 * description: Design a logger system that receive stream of messages along with its timestamps, each message should
 * be printed if and only if it is not printed in the last 10 seconds.
 *
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given
 * timestamp, otherwise returns false.
 *
 * It is possible that several messages arrive roughly at the same time.
 */

public class LoggerRateLimiter {
    private Map<String, Integer> db;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        db = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!db.containsKey(message)) {
            db.put(message, timestamp);
            return true;
        } else {
            Integer dbTimestamp = db.get(message);
            if (timestamp - dbTimestamp >= 10) {
                db.replace(message, timestamp);
                return true;
            }
        }
        return false;
    }
}
