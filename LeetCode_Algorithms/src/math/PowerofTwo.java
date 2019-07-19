package math;

/**
 * #231 check if number is power of 2
 * @author Ryan
 *
 */
public class PowerofTwo {

    public boolean isPowerOfTwo(int n) {
    	if(n<=0) return false;
    	while(n>1){
    		if(n%2 != 0) return false;
    		n = n /2;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
