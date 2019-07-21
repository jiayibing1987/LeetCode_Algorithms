package math;

/**
 * #50 pow(x,n)
 * @author Ryan
 *
 */
public class PowXN {

    public double myPow(double x, int n) {
    	if(n==0) return 1.0;
    	if(x==0) return 0.0;
    	if(x==1.0) return x;
    	if(x==-1.0)return n%2==0? 1.0 : -1.0; 
    	if(n<0){ 
    		x = 1.0/x;
    		if(n==Integer.MIN_VALUE)
    			n = Integer.MAX_VALUE;
    		else
    			n = n*-1;
    	}
    	double res = 1.0;
    	while(n>=1){
    		res = res*x;
    		n--;
    		if(res>=0 && res<Double.MIN_VALUE)
    			return 0.0;
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		PowXN p = new PowXN();
		System.out.println(p.myPow(-1, 2147483647));
	}

}
