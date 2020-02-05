package com.imola.leetcode.stack;

/**
 * @author Heng Yu
 * @date 2/4/20 11:21 PM
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 232:  Implement Queue using Stacks
 *
 * description:
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 * example:
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 *
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and
 * is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque
 * (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty
 * queue).
 */

public class ImplementQueueUsingStacks {
    private Deque<Integer> stack;
    private Integer first;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        stack = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
        if (stack.size() == 1)
            first = x;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Deque<Integer> temp = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        int res = temp.pop();
        first = temp.peek();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        return first;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
