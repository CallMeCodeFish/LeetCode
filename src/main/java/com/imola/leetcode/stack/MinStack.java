package com.imola.leetcode.stack;

/**
 * @author Heng Yu
 * @date 2/4/20 10:25 PM
 */

import java.util.*;

/**
 * leetcode 155:  Min Stack
 *
 * description:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

class MyMinStack {
    //list
    List<Integer> list;
    //priority queue
    PriorityQueue<Integer> heap;

    /** initialize your data structure here. */
    public MyMinStack() {
        list = new ArrayList<>();
        heap = new PriorityQueue<>();
    }

    public void push(int x) {
        list.add(x);
        heap.offer(x);
    }

    public void pop() {
        Integer toDelete = list.remove(list.size() - 1);
        heap.remove(toDelete);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return heap.peek();
    }
}


/**
 * 不用priority queue的做法，真正实现了所有操作在常数时间完成
 */
public class MinStack {

    class Node{
        int val;
        int min;
        public Node(int x){
            this.val = x;
        }
    }

    Deque<Node> stack;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int x) {
        Node node = new Node(x);
        node.min = stack.isEmpty()? x : Math.min(x, stack.peek().min);
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
