package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * #22
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * @author Ryan
 *
 */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> results = new ArrayList<String>();
		backTrack(results, "(", n);
		return results;
	}

	private void backTrack(List<String> results, String s, int n) {
		if(s.length() == n*2 ){
			if(checkParentheses(s.toCharArray())==true)
				results.add(s);
			return;
		}else{
			for(int i=0; i<2; i++){
				String newString;
				if(i==0)
					newString = s.concat("(");
				else
					newString = s.concat(")");
				backTrack(results, newString, n);
			}
		}
	}

	private boolean checkParentheses(char[] c) {
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ')' && !s.isEmpty() && s.peek() == '(') {
				s.pop();
			}else{
				s.push(c[i]);
			}
		}
		if(s.isEmpty())
			return true;
		else 
			return false;
	}

	public static void main(String[] args) {
		GenerateParentheses g = new GenerateParentheses();
		System.out.println(g.generateParenthesis(3));
		g.checkParentheses(new String("())(").toCharArray());
	}

}
