package hashtable;

import java.util.HashSet;


/**
 * Write an algorithm to determine if a number is "happy".

 * A happy number is a number defined by the following process: Starting with any positive integer, 
 * replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), 
 * or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 

 * Input: 19
 * Output: true
 * Explanation: 
 * 12 + 92(square) = 82 
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 */
public class HappyNumber {

	public boolean isHappy(int n) {
		char[] num = Integer.toString(n).toCharArray();
		int result = 0;
		HashSet<String> set = new HashSet<String>();
		boolean found = false;
		while (true) {
			for (char c : num) {
				result += Math.pow(Character.getNumericValue(c), 2);
			}
			set.add(new String(num));
			//find happy number
			if(result == 1){
				found = true;
				break;
			}
			else{
				//new number after that
				num = Integer.toString(result).toCharArray();
				result = 0;
				//set has this number means it is into a circle
				if(set.contains(new String(num)))
					return false;
			}
		}
		return found;
	}

	public static void main(String[] args) {
		HappyNumber happy = new HappyNumber();
		boolean isHappy = happy.isHappy(19);
		System.out.println(isHappy);
	}

}
