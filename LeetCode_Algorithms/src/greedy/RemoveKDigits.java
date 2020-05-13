package greedy;

import java.util.Stack;

/**
 * 402. Remove K Digits
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number so that the new number is the smallest possible.
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = num.toCharArray();
        for(int i=0; i<num.length(); i++) {
            while(!stack.isEmpty() && k > 0 && chars[i] < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(chars[i]);
        }

        while(k > 0) {
            stack.pop();
            k--;
        }
        //append string from stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        //remove tail zero
        while(sb.length() > 0 && sb.charAt(sb.length()-1) == '0')
            sb.deleteCharAt(sb.length()-1);

        String res = sb.reverse().toString();
        return res.isEmpty()? "0" : res;
    }

    public static void main (String[] args) {
        RemoveKDigits r = new RemoveKDigits();
        System.out.print(r.removeKdigits("1234567890", 9));
    }
}
