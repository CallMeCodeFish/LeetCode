package com.imola.leetcode.hashtable;

/**
 * @author Heng Yu
 * @date 1/20/20 11:03 AM
 */

import java.util.*;

/**
 * leetcode 355
 *
 * description: Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is
 * able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 *
 * postTweet(userId, tweetId): Compose a new tweet.
 *
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
 * be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least
 * recent.
 *
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 *
 * example:
 * Twitter twitter = new Twitter();
 *
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 *
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 *
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 *
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 *
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */

public class DesignTwitter {
    private Set<Integer> users;
    private Map<Integer, Set<Integer>> followees;
    private Map<Integer, List<Integer>> posts;
    private Set<Integer> tweets;
    private Map<Integer, Integer> dbTweets;
    private int tweetCount;

    /** Initialize your data structure here. */
    public DesignTwitter() {
        users = new HashSet<>();
        followees = new HashMap<>();
        posts = new HashMap<>();
        tweets = new HashSet<>();
        dbTweets = new HashMap<>();
        tweetCount = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!users.contains(userId)) {
            addUser(userId);
        }

        if (!tweets.contains(tweetId)) {
            tweets.add(tweetId);
            dbTweets.put(++tweetCount, tweetId);
            posts.get(userId).add(tweetCount);
        }
    }

    private void addUser(int userId) {
        users.add(userId);
        Set<Integer> set = new HashSet<>();
        set.add(userId);
        followees.put(userId, set);
        List<Integer> post = new ArrayList<>();
        posts.put(userId, post);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
     * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!users.contains(userId)) {
            addUser(userId);
        }
        Set<Integer> userFollowees = followees.get(userId);

        List<Integer> newsFeedDb = new ArrayList<>();
        for (Integer userFollowee : userFollowees) {
            List<Integer> userPosts = posts.get(userFollowee);
            newsFeedDb.addAll(userPosts);
        }
        if (newsFeedDb.size() == 0)
            return new ArrayList<>();

        Collections.sort(newsFeedDb);
        Collections.reverse(newsFeedDb);

        List<Integer> newsFeed = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            if (i < newsFeedDb.size()) {
                Integer tweet = dbTweets.get(newsFeedDb.get(i));
                newsFeed.add(tweet);
            }
        }

        return newsFeed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!users.contains(followerId)) {
            addUser(followerId);
        }

        if (!users.contains(followeeId)) {
            addUser(followeeId);
        }

        if (!followees.get(followerId).contains(followeeId)) {
            followees.get(followerId).add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId || !users.contains(followerId) || !users.contains(followeeId) || !followees.get(followerId).contains(followeeId))
            return;
        
        followees.get(followerId).remove(followeeId);
    }
}

/**
 * the code will be more readable and understandable if OOP concepts rather than pure in-built data structures are implemented.
 */
