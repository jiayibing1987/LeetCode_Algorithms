package stack;

import java.util.Stack;


/**
 * #1021
 * @author Ryan
 *
 */
public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<S.length(); i++){
        	if(chars[i] == '('){
        		if(!stack.isEmpty())
        			sb.append(chars[i]);
        		stack.push(chars[i]);
        	}else if(chars[i] == ')'){
        		if(stack.peek() == '('){
        			stack.pop();
        		}else
        			stack.push(chars[i]);
        		if(!stack.isEmpty()){
        			sb.append(chars[i]);
        		}
        	}
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		String s1 = "(()())(())";
		String s2 = "(()())(())(()(()))";
		String s3 = "()()";
		RemoveOutermostParentheses re = new RemoveOutermostParentheses();
		System.out.println(re.removeOuterParentheses(s2));
	}

}
