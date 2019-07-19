package string;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * @author Ryan
 *
 */
public class ReverseInteger {

    public int reverse(int x) {
    	String s = Integer.toString(x);
    	if(x<0){
    		s = s.substring(1);
    	}
    	s = new StringBuilder(s).reverse().toString();
    	s.replaceFirst("^0+(?!$)", "");
    	long res = Long.parseLong(s);
    	if(res > Integer.MAX_VALUE ){
    		return 0;
    	}
    	return (int) (x<0? 0-res : res);
    }
    
	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(1534236469));
	}

}
