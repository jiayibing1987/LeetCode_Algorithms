package string;

/**
 * #461 The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * 
 * @author Ryan
 *
 */
public class HammingDistance {

	public int hammingDistance(int x, int y) {
		int diff = 0;	
		StringBuilder xString = new StringBuilder(Integer.toBinaryString(x));
		StringBuilder yString = new StringBuilder(Integer.toBinaryString(y));
		int lengthDiff = x > y? xString.length() - yString.length() : yString.length() - xString.length();
		
		for(int i=1; i <= lengthDiff; i++){
			if(x < y)
				xString = new StringBuilder("0").append(xString);
			else
				yString = new StringBuilder("0").append(yString);
		}
		
		for(int i=0; i<xString.length(); i++){
			if(xString.charAt(i) != yString.charAt(i))
				diff++;
		}
		
		return diff;
	
		//one line solution
		//return Integer.bitCount(x ^ y);
	}

	public static void main(String[] args) {
		HammingDistance hd = new HammingDistance();
		int x = 1;
		int y = 4;
		System.out.println(hd.hammingDistance(x, y));
	}

}
