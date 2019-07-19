package stack;

import java.util.Stack;

/**
 * #856
 * @author Ryan
 *
 */
public class ScoreofParentheses {

	public int scoreOfParentheses(String S) {
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (char c : S.toCharArray()) {
			if (c == '(') {
				stack.push(0);
			} else {
				int current = 0;
				if (stack.peek() == 0) {
					stack.pop();
					stack.push(1);
				} else {
					//get sum all numbers in current bracket
					while (!stack.isEmpty() && stack.peek() != 0) {
						current += stack.pop();
					}
					stack.pop();// pop 0
					stack.push(current * 2);
				}
			}
		}
		while(!stack.isEmpty()){
			result += stack.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		ScoreofParentheses sc = new ScoreofParentheses();
		System.out.println(sc.scoreOfParentheses("(()(()))"));
	}

}
