package twopointer;


/**
 * 167. Two Sum II - Input array is sorted
 *
 */
public class TwoSumInSortedArray {
	public int[] twoSum(int[] num, int target) {
	    int[] indice = new int[2];

	    int left = 0, right = num.length - 1;
	    while (left < right) {
	        int v = num[left] + num[right];
	        if (v == target) {
	            indice[0] = left + 1;
	            indice[1] = right + 1;
	            break;
	        } else if (v > target) {
	            right --;
	        } else {
	            left ++;
	        }
	    }
	    return indice;
	}
}
