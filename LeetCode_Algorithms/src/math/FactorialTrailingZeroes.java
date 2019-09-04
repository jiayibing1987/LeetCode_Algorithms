package math;

/**
 * 172. Factorial Trailing Zeroes
 * @author Ryan
 *
 */
public class FactorialTrailingZeroes {

	//brute force but have overflow issues
    public int trailingZeroes1(int n) {
        int res = 1;
        while(n>1){
            res *= n;
            n--;
        }
        String s = String.valueOf(res);
        char[] charArray = s.toCharArray();
        int count = 0;
        for(int i=charArray.length-1; i>=0; i--){
            if(charArray[i] == '0')
                count++;
            else
                break;
        }
        return count;
    }
    
    //only count for how many "5" that n has, so it will be 5,10,15,20..... which is n/5
    //need to be carefull that 25 has two "5"s so, 25/5 = 5 but still has one more "5"
    //so keep doing n = n/5 until n is 0
    public int trailingZeroes(int n) {
    	int res = 0;
    	while(n>0){
    		res += n/5;
    		n = n/5;
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		FactorialTrailingZeroes f = new FactorialTrailingZeroes();
		System.out.println(f.trailingZeroes(13));
	}

}
