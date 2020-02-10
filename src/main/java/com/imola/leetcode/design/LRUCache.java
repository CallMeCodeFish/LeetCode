package com.imola.leetcode.design;

/**
 * @author Heng Yu
 * @date 2/9/20 7:28 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 146: LRU Cache
 * <p>
 * description:
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * example:
 * LRUCache cache = new LRUCache( 2 capacity);
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

public class LRUCache {
    private class CacheNode {
        int key;
        int value;
        CacheNode next;
        CacheNode previous;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, CacheNode> nodes;
    int capacity;
    CacheNode first; //the oldest data
    CacheNode last; //the newest data

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodes = new HashMap<>();
    }

    public int get(int key) {
        if (!nodes.containsKey(key))
            return -1;
        CacheNode node = nodes.get(key);
        int value = node.value;
        if (last == node) { //node is the last node
            return value;
        }

        if (first == node) { //node is the first node
            first = node.next;
            first.previous = null;
            node.next = null;
            node.previous = last;
            last.next = node;
            last = last.next;
        } else { //node is the middle node
            node.previous.next = node.next;
            node.next.previous = node.previous;
            node.previous = last;
            node.next = null;
            last.next = node;
            last = last.next;
        }
        return value;
    }

    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            get(key);
            nodes.get(key).value = value;
            return;
        }
        CacheNode newNode = new CacheNode(key, value);
        //check capacity
        if (nodes.size() < capacity) { //put directly
            if (nodes.isEmpty()) {
                first = last = newNode;
                nodes.put(key, newNode);
            } else {
                newNode.previous = last;
                last.next = newNode;
                last = last.next;
                nodes.put(key, newNode);
            }
        } else { //add first and then delete the oldest data
            //add new node
            newNode.previous = last;
            last.next = newNode;
            last = last.next;
            nodes.put(key, newNode);
            //delete oldest
            CacheNode temp = first;
            first = first.next;
            first.previous = null;
            nodes.remove(temp.key);
        }
    }
}
