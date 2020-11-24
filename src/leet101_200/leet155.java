package leet101_200;

import java.util.Deque;
import java.util.LinkedList;

public class leet155 {
    /** initialize your data structure here. */
    Deque<Integer> stack;
    Deque<Integer> minstack;
    public leet155() {
        stack = new LinkedList<>();
        minstack = new LinkedList<>();
        minstack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minstack.push(Math.min(x,minstack.getLast()));
    }

    public void pop() {
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minstack.getLast();
    }
}
