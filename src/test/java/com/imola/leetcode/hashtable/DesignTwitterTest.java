package com.imola.leetcode.hashtable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/20/20 3:24 PM
 */

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 *
 */


class DesignTwitterTest {
    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1, 1);
        List<Integer> newsFeed1 = twitter.getNewsFeed(1);
        System.out.println("newsFeed1: " + newsFeed1);

        twitter.follow(2, 1);
        List<Integer> newsFeed2 = twitter.getNewsFeed(2);
        System.out.println("newsFeed2: " + newsFeed2);

        twitter.unfollow(2, 1);
        List<Integer> newsFeed3 = twitter.getNewsFeed(2);
        System.out.println("newsFeed3: " + newsFeed3);
    }
}