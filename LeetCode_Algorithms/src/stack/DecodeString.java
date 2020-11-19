package stack;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();

        Stack<Character> stack = new Stack<>();
        for(char c : chars) {
            if(c != ']') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while(!s.isEmpty()) {
                    char cur = stack.pop();
                    if(cur == '[') {
                        break;
                    }else if(cur >= 'a' && cur <= 'z'){
                        sb.append(cur);
                    }
                }

                //get number k
                StringBuilder sb_int = new StringBuilder();
                int count = 0;
                int k = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k += Character.getNumericValue(stack.pop()) * Math.pow(10, count);
                }
                for(int i=0; i<k; i++) {
                    for(int j=sb.length()-1; j>=0; j--) {
                        stack.push(sb.charAt(j));
                    }
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
