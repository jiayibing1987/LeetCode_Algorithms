package dynamicprogramming;

/**
 * #343
 * Given a positive integer n, break it into the 
 * sum of at least two positive integers and maximize the product of those integers.
 *  Return the maximum product you can get.
 * @author Ryan
 *
 */
public class IntegerBreak {

//	public int integerBreak(int n) {
//	        int[] dp = new int[n+1];
//	        dp[1] = 1;
//	        if(n==2)
//	        	return 1;
//	        if(n==3)
//	        	return 2;
//	        dp[2] = 2;
//	        dp[3] = 3;
//	        
//	        for(int i=3; i<=n; i++){
//	        	for(int j=0; j<i; j++){
//	        		dp[i] = Math.max(dp[i], dp[j]*dp[i-j]);
//	        	}
//	        }
//	      return dp[n];
//	}
	
	public int integerBreak(int n){
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i=3; i<=n; i++){
			for(int j=1; j<i; j++)
				dp[i] = Math.max(dp[i], j*Math.max(dp[i-j], i-j));
		}
		return dp[n];
	}
	
	  
	public static void main(String[] args) {
		IntegerBreak b = new IntegerBreak();
		System.out.println(b.integerBreak(10)); 
	}

}
