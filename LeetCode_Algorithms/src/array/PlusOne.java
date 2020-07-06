package array;

import java.util.Arrays;
import java.util.Stack;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int inc = 1;
        for(int i = digits.length-1; i>=0; i--) {
            int temp = digits[i] + inc;
            if(temp == 10) {
                inc = 1;
                temp = 0;
            }else {
                inc = 0;
            }
            stack.push(temp);
        }
        if(inc == 1) stack.push(1);
        int[] res = new int[stack.size()];
        for(int i=0; i<res.length; i++)
            res[i] = stack.pop();
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.print(Arrays.toString(new PlusOne().plusOne(a)));
    }
}
