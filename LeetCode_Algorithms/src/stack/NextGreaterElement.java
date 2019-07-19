package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * #496
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1¡¯s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * @author Ryan
 *
 */
public class NextGreaterElement {

	//using a stack, keep decending order, each scan time the current number
	//if current>s.peek() , remove all numbers that smaller than current
	//push current number in the top of stack
	//e.g. 6,5,3,2,1 -- 4
	//     6,5,4    --1,2,3 are removed and store in map
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    		Stack<Integer> s = new Stack<Integer>();
    		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    		
    		for(Integer num: nums2){
    			while(!s.isEmpty() && s.peek()<num){
    				m.put(s.pop(), num);
    			}
    			s.push(num);
    		}
    		int[] result = new int[nums1.length];
    		for(int i=0; i<nums1.length; i++){
    			result[i] = m.getOrDefault(nums1[i], -1);
    		}
    		return result;
    } 
    
    
	public static void main(String[] args) {
		int[] n1 = {4,1,2};
		int[] n2 = {1,3,4,2};
		NextGreaterElement ne = new NextGreaterElement();
		System.out.print(Arrays.toString(ne.nextGreaterElement(n1, n2)));
	}

}
