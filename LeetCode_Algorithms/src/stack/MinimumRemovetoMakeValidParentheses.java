package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> p_stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!Character.isLetter(c)) {
                if(!p_stack.isEmpty() && c == ')' && s.charAt(p_stack.peek()) == '(') {
                    p_stack.pop();
                } else {
                    p_stack.push(i);
                }
            }
        }

        Set<Integer> set = new HashSet<>(p_stack);
        for(int i=0; i<s.length(); i++) {
            if(!set.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
