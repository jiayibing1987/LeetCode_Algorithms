package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #225
 * @author Ryan
 *
 */
public class MyStack {

	Queue<Integer> q1;
	Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
         q2.add(x);
         while(!q1.isEmpty()){
        	 q2.add(q1.poll());
         }
         q1 = q2;
         q2 = new LinkedList<Integer>(); 
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
