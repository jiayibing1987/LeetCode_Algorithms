package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementTwo {

	
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        //Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        
        for(int i=0; i<nums.length*2; i++){
        	int num = nums[i%nums.length];
        	while(!stack.isEmpty() && nums[stack.peek()%nums.length] < num){
        		//map.put(stack.pop() ,num);
        		int index = stack.pop();
        		if(index < nums.length)
        			result[index] = num;
        	}
        	stack.push(i);
        }
//        for(int i=0; i<nums.length; i++){
//        	result[i] = map.getOrDefault(i, -1);
//        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] n1 = {100,1,11};
		NextGreaterElementTwo next = new NextGreaterElementTwo();
		System.out.println(Arrays.toString(next.nextGreaterElements(n1)));
	}

}
