package com.mountain.monk.leetcode;

import java.util.Stack;

public class NO_0232_MyQueue {

}

class MyQueue {
    Stack<Integer> inStack=new Stack<>();
    Stack<Integer> outStack=new Stack<>();


    public MyQueue() {

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.pop();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();

    }
    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }


}
