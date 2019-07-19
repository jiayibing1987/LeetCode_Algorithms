package stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {

    public String removeDuplicates(String S) {
    	StringBuilder sb = new StringBuilder();
        char[] c = S.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<S.length(); i++){
        	if(!stack.isEmpty()&& stack.peek() == c[i]){
        		stack.pop();
        	}else{
        		stack.push(c[i]);
        	}
        }
        for(char ch : stack){
        	sb.append(ch);
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		RemoveAllAdjacentDuplicates r = new RemoveAllAdjacentDuplicates();
		String s = "azxxzy";
		System.out.println(r.removeDuplicates(s));
	}

}
