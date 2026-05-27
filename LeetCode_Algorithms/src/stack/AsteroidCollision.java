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

    public int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for(int a : asteroids) {
            while(!s.isEmpty() && s.peek() > 0 && a < 0) {
                int b = s.peek();
                if(a + b != 0) {
                    if(Math.abs(a) > Math.abs(b)) {
                        s.pop();
                    } else {
                        a = 0;
                        break;
                    }
                } else {
                    s.pop();
                    a = 0;
                    break;
                }
            }

            if(a != 0)
                s.push(a);
        }

        if(s.isEmpty()) return new int [0];
        int size = s.size();
        int[] res = new int [size];

        for(int i = size - 1; i >= 0; i --) {
            res[i] = s.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision a = new AsteroidCollision();
        int[] array1 = new int[]{5,10,-5};
        int[] array2= new int[]{8, -8};
        System.out.println(Arrays.toString(a.asteroidCollision1(array1)));
        System.out.println(Arrays.toString(a.asteroidCollision1(array2)));

    }
}
