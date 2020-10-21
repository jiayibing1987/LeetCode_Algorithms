package stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int cur : asteroids) {
            while(!stack.isEmpty() && cur < 0 && stack.peek() > 0) {
                int pre = stack.pop();
                if(Math.abs(cur) < Math.abs(pre)) {
                    cur = pre;
                } else if(Math.abs(cur) > Math.abs(pre)) {
                    //do nothing, keep cur as it is
                } else {
                    cur = 0;
                    break;
                }
            }
            if(cur != 0)
                stack.push(cur);
        }

        int n = stack.size();
        int[] res = new int[n];
        for(int i= n-1; i>=0; i--)
            res[i] = stack.pop();
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision a = new AsteroidCollision();
        int[] array = new int[]{5,10,-5};
        System.out.println(Arrays.toString(a.asteroidCollision(array)));
    }
}
