package bitmanipulation;

/**
 * 191. Number of 1 Bits
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 * @author Ryan
 *
 */
public class Numberof1Bits {

    // set a mask value as 1 which in 32 bit is 000000.....00000001
	//use & operation with n to check each bits for n, if current bit at n is 0 then n&mask = 0
	//left shift mask such as 000000....00000010, 
	//keep doing this for 32 times
    public int hammingWeight(int n) {
    	int mask = 1;
    	int count = 0;
    	for(int i=1; i<=32; i++){
    		if((n&mask)!= 0)
    			count++;
    		mask = mask<<1;
    	}
    	return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
