package twopointer;

import java.util.Arrays;


/**
 * #977 Squares of a Sorted Array
 * Given an array of integers A sorted in non-decreasing order, 
 * return an array of the squares of each number, also in sorted non-decreasing order.
 * @author Ryan
 *
 */
public class SquaresofaSortedArray {

    public int[] sortedSquares(int[] A) {
    	int i = 0;
    	int j = A.length-1;
    	int k = A.length-1;
    	int[] result = new int[A.length];
    	
    	while(k>=0){
    		if(A[i]*A[i] > A[j]*A[j]){
    			result[k] = A[i]*A[i];
    			i++;
    		}
    		else{
    			result[k] = A[j]*A[j];
    			j--;
    		}
    		k--;
    	}
    	return result;
    }
	
	public static void main(String[] args) {
		int[] a = {-4,-1,0,3,10};
		int[] b = {-7,-3,2,3,11};
		
		SquaresofaSortedArray s = new SquaresofaSortedArray();
		System.out.println(Arrays.toString(s.sortedSquares(a)));
		System.out.println(Arrays.toString(s.sortedSquares(b)));

	}

}
