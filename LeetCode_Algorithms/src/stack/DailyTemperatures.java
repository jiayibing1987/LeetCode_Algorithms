package stack;

import java.util.Stack;

/**
 * #739. Daily Temperatures
 * @author Ryan
 *
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<T.length; i++){
        	while(!stack.isEmpty() && T[stack.peek()]< T[i]){
        		int index = stack.pop();
        		result[index] = i - index; 
        	}
        	stack.push(i);
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
