package stack;

import java.util.Stack;

public class MyQueue {

	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
    /** Initialize your data structure here. */
    public MyQueue() {
    	stack1 = new Stack<Integer>();
    	stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack1.isEmpty()){
        	stack2.push(stack1.pop()); 
        }
        stack1.push(x);
        while(!stack2.isEmpty()){
        	stack1.push(stack2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
