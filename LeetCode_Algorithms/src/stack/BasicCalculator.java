package stack;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        return eval(s, 0)[0];
    }

    public int[] eval (String s, int i) {
        Stack<Object> stack = new Stack<>();
        while(i < s.length() && s.charAt(i) != ')') {
            char c = s.charAt(i);
            if(Character.isDigit(c) ) {
                if(stack.isEmpty() || stack.peek().equals("+")  || stack.peek().equals("-") ) {
                    stack.push(Character.getNumericValue(c));
                }else if (stack.peek() instanceof Integer) {
                    Integer lastInt = (Integer) stack.pop();
                    stack.push(lastInt * 10 + Character.getNumericValue(c));
                }
            } else if (c == '(') {
                int[] value = eval(s, i + 1);
                stack.push(value[0]);
                i = value[1];
            } else if (c == '+' || c == '-') {
                if (stack.size() > 1)
                    calcStack(stack);
                stack.push(String.valueOf(c));
            }
            i++;
        }
        return new int[] {calcStack(stack), i} ;
    }

    private int calcStack (Stack<Object> stack) {
        if(stack.size() == 1) {
            return (int) stack.peek();
        }
        else {
            int secondNumber = (int) stack.pop();
            String operator = (String) stack.pop();
            if(operator.equals("-")) {
                secondNumber = secondNumber * -1;
            }
            if(stack.isEmpty()) {
                stack.push(secondNumber);
                return secondNumber;
            }

            int firstNumber = (int) stack.pop();
            if(!stack.isEmpty() && stack.pop().equals("-")) {
                firstNumber = firstNumber * -1;
            }
            int res = firstNumber + secondNumber;
            stack.push(res);
            return res;
        }
    }

    public static void main(String[] args) {
        BasicCalculator b = new BasicCalculator();
        //System.out.println(b.calculate("-2+ 1"));
        //System.out.println(b.calculate("2-1 + 2"));
        System.out.println(b.calculate("(1+(4+5+2)-3)+(6+8)"));

    }
}
