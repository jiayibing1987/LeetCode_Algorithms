package contest;

import java.util.Stack;

public class CountCollisionsonaRoad {

    public int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(char d : directions.toCharArray()) {
            if(d == 'L') {
                if(stack.isEmpty()) {

                } else if (stack.peek()== 'R') {
                    count += 2;
                    stack.pop();
                    stack.push('S');
                } else if (stack.peek()== 'S') {
                    count ++;
                }
            } else if (d== 'R') {
                if(!stack.isEmpty() && stack.peek() == 'S')
                    stack.clear();
                stack.push('R');
            } else if (d == 'S') {
                if(stack.isEmpty()) {
                    stack.push('S');
                } else if (stack.peek()== 'R') {
                    count += stack.size();
                    stack.clear();
                    stack.push('S');
                }
            }
            System.out.println(count);
        }
        return count;
    }

    public static void main(String[] args) {
        CountCollisionsonaRoad c = new CountCollisionsonaRoad();
        System.out.println(c.countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }
}
