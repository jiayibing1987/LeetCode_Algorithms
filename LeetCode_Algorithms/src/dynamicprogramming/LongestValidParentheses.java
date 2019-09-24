package dynamicprogramming;

import java.util.Stack;

/**
 * #32. Longest Valid Parentheses
 * @author Ryan
 *
 */
public class LongestValidParentheses {

	//brute force
    public int longestValidParentheses1(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int max = 0;
        for(int i=0; i<c.length; i++){
        	int cur_length = 0; stack.clear();
        	for(int j=i; j<c.length; j++){
        		if(stack.isEmpty())
        			stack.push(c[j]);
        		else{
        			if(stack.peek() == '(' && c[j] == ')'){
        				stack.pop();
        				if(stack.isEmpty())
        				 cur_length = j-i+1;
        			}
        			else if(stack.peek() == '(' && c[j] == '(')
        				stack.push(c[j]);
        			else // )) or )(
        				break;
        		}
        	}
        	max = Math.max(cur_length, max);
        }
        return max;
    }
    
    //using stack
    public int longestValidParentheses2(String s) {
        char[] c = s.toCharArray();
        Stack<Character> char_stack = new Stack<Character>();
        Stack<Integer> number_stack = new Stack<Integer>();
        int max = 0;
        for(int i=0; i<c.length; i++){
        	//if got a () pair which means we need close a bracket, remove one 0 from number stack
        	if(!char_stack.isEmpty() && char_stack.peek() == '(' && c[i] == ')'){
        		char_stack.pop();
        		this.addStack(number_stack, 2);
        	}else if(c[i] == '('){
        		char_stack.push('(');
        		number_stack.push(0);
        	}else if(c[i] == ')'){
        		char_stack.push(')');
        		number_stack.push(-1);
        	}
        	max = Math.max(max, number_stack.peek());

        }
        return max;
    }
    
    //remove a 0 and add all other non zero together then push back
    private void addStack(Stack<Integer> stack, int n){
    	int count = 0;
    	int res = n;
    	while(!stack.isEmpty() && stack.peek() >= 0){
    		if(stack.peek() == 0) count ++;
    		if(count == 2) break;
    		res += stack.pop();
    	}
    	stack.push(res);
    }
    
    
    //dp way
    public int longestValidParentheses(String s) {
    	if(s.length() <= 1) return 0;
    	int[] dp = new int[s.length()];
    	for(int i=1; i<s.length(); i++){
    		if(s.charAt(i) == ')'){
    			// string like () then dp[i] = dp[i-2]+2  xxxx()  xxxxis a valid parentheses
    			if(s.charAt(i-1) == '(')
    				dp[i] = (i-2>=0? dp[i-2] : 0) + 2;
    			//string like )), just check the second last ) at i-1, if there is a valid parentheses at that postion
    			// then there must a '(' crosssponging to it, the postion is i-dp[i-1]-1, 
    			//(dp[i-1] is length of  valid subsrting end at i-1
    			// e.g. string: xx (()) dp: xx002i, dp[i] = dp[i-1]+2
    			//also xx will be another valid substring before that, we also add it to dp[i]
    			//which is dp[i-dp[i-1]-2]	
    		    else if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1) == ')'){
    		    	int lengthOfSubString = i-dp[i-1]-2 >=0 ? dp[i-dp[i-1]-2] : 0;
    		    	dp[i] = dp[i-1] + lengthOfSubString + 2; 
    		    }
    		}
    	}
    	int max = 0;
    	for(int n : dp)
    		max = Math.max(max, n);
    	return max;
    }
    
	public static void main(String[] args) {
		String s = ")(((((()())()()))()(()))(";
		String s1 = "(()";
		LongestValidParentheses lvp = new LongestValidParentheses();
		System.out.println(lvp.longestValidParentheses(s1));
	}

}
