package math;

/**
 * #326 power of three
 * @author Ryan
 *
 */
public class PowerofThree {

    public boolean isPowerOfThree(int n) {
    	if(n<=0) return false;
    	while(n%3 == 0){
    		n = n / 3;
    	}
    	return n==1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
