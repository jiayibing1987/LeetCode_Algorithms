package dynamicprogramming;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author Ryan
 *
 */
public class ClimbingStairs {

	
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=1; i<n; i++){
        	dp[i+1] = dp[i] + dp[i-1];
        }
        
        return dp[n];
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
