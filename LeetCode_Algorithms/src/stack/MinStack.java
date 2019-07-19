package stack;

import java.util.Stack;

/**
 * #155
 * @author Ryan
 *
 */
public class MinStack {

    /** initialize your data structure here. */
	Stack<Integer> stack;
	Stack<Integer> minStack; //second stack to store history of min value 
    public MinStack() {
    	stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x < minStack.peek())
        	minStack.push(x);
    }
    
    public void pop() {
        if(stack.peek() == minStack.peek()){
        	minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin(){
        return minStack.peek();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
