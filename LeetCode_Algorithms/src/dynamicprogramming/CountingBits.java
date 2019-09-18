package dynamicprogramming;

import java.util.Arrays;

/**
 * 338. Counting Bits
 * @author Ryan
 *
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        int exp = 0;
        int n = 1;
        while(n <= num){
        	dp[n] = 1;
        	for(int i=1; i<n; i++){
        		if(n+i > num) break;
        		dp[n+i] = dp[n]+dp[i];
        	}
        	exp++;
        	n = (int) Math.pow(2, exp);
        }
        return dp;
    }
    
	public static void main(String[] args) {
		CountingBits c = new CountingBits();
		System.out.println(Arrays.toString(c.countBits(2)));
	}

}
