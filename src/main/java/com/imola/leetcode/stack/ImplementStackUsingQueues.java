package com.imola.leetcode.stack;

/**
 * @author Heng Yu
 * @date 2/4/20 10:51 PM
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 225:  Implement Stack using Queues
 *
 * description:
 * implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 * example:
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 *
 * Notes:
 *
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and
 * is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque
 * (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty
 * stack).
 */

public class ImplementStackUsingQueues {
    private Queue<Integer> stack;
    private Integer top;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        stack = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.offer(x);
        this.top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = stack.size();
        int res = 0;
        for (int i = 0; i < size; ++i) {
            Integer integer = stack.poll();
            if (i == size - 2) {
                top = integer;
            }
            if (i != size - 1) {
                stack.offer(integer);
            } else {
                res = integer;
            }
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
