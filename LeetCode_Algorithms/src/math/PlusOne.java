package math;

import java.util.Arrays;


/**
 * #66
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
The digits are stored such that the most significant digit is at the head of the list, 
and each element in the array contain a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.
 * @author Ryan
 *
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
    	int[] result = new int[digits.length];
    	boolean isIncreament = false;
                                       	
    	for(int i=digits.length-1; i>=0; i--){
    		int number;
    		if(i == digits.length-1)
    			number = digits[i]+1;
    		else
    			number = isIncreament? digits[i]+1: digits[i];
    		
    		if(number == 10){
    			number = 0;
    			isIncreament = true;
    		}else{
    			isIncreament = false;
    		}
    		result[i] = number;
    	}
    	
    	if(result[0] == 0){
    		int[] newResult = new int[digits.length+1];
    		newResult[0] = 1;
    		result = newResult;
    	}
    	return result;
    }
	
	public static void main(String[] args) {
		PlusOne p = new PlusOne();
		int[] a = {1,2,3};
		System.out.println(Arrays.toString(p.plusOne(a)));
		
		int[] b = {4,9,9,9};
		System.out.println(Arrays.toString(p.plusOne(b)));
	}

}
