package math;

/**
 * #342 Check if number is power of 4
 * @author Ryan
 *
 */
public class PowerofFour {

    public boolean isPowerOfFour(int num) {
    	if(num<=0) return false;
    	while(num%4 == 0){
    		num = num / 4;
    	}
    	return num==1;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
