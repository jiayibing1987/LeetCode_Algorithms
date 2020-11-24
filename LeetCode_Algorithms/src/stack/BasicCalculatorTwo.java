package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BasicCalculatorTwo {

    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;

        Set<String> set = Set.of("+", "-", "*", "/");
        Stack<String> stack = new Stack<String>();
        List<String> list = new ArrayList<>();

        Integer preValue = null;
        for(char c : s.toCharArray()) {
            if(c == ' ') continue;
            if(Character.isDigit(c)) {
                if(preValue == null) {
                    preValue = Character.getNumericValue(c);
                } else {
                    int cur = preValue * 10 + Character.getNumericValue(c);
                    preValue = cur;
                }

            }else{
                list.add(String.valueOf(preValue));
                list.add(String.valueOf(c));
                preValue = null;
            }
        }
        list.add(String.valueOf(preValue));

        for(String str : list) {
            if(set.contains(str) || stack.isEmpty()) {
                stack.push(str);
            } else {
                String op = stack.peek();
                if(op.equals("*")) {
                    stack.pop();
                    int v = Integer.valueOf(stack.pop()) * Integer.valueOf(str);
                    stack.push(String.valueOf(v));
                } else if (op.equals("/")) {
                    stack.pop();
                    int v = Integer.valueOf(stack.pop()) / Integer.valueOf(str);
                    stack.push(String.valueOf(v));
                } else {
                    stack.push(str);
                }
            }
        }

        Stack<String> stack2 = new Stack<String>();
        while(!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        int temp = 0;
        while(!stack2.isEmpty()) {
            String str = stack2.pop();
            if(!set.contains(str)) {
                temp = Integer.valueOf(str);
            }else {
                if(str.equals("+")) {
                    int v = temp + Integer.valueOf(stack2.pop()) ;
                    stack2.push(String.valueOf(v));
                }else if(str.equals("-")) {
                    int v = temp- Integer.valueOf(stack2.pop());
                    stack2.push(String.valueOf(v));
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        BasicCalculatorTwo calc = new BasicCalculatorTwo();
       // System.out.println(calc.calculate("3+2*2"));
        //System.out.println(calc.calculate("1-1+1"));
        System.out.println(calc.calculate("0-2147483647"));

    }
}
