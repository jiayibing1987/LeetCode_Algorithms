package dynamicprogramming;


/**
 *	#746 
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
Once you pay the cost, you can either climb one or two steps. 
You need to find minimum cost to reach the top of the floor,
 and you can either start from the step with index 0, or the step with index 1.
 * @author Ryan
 *
 */
public class MinCostClimbingStairs {

	
    public int minCostClimbingStairs(int[] cost) {
    	if(cost.length == 0)
    		return 0;
    	int[] dp = new int[cost.length+1];
    	dp[0] = 0;
    	dp[1] = 0;
    	
    	for(int i=1; i<cost.length; i++){
    		dp[i+1] = Math.min(dp[i-1]+cost[i-1], dp[i]+cost[i]);
    	}
    	return dp[cost.length];
    }
	
	public static void main(String[] args) {
		MinCostClimbingStairs m = new MinCostClimbingStairs();
		int[] a = {10, 15, 20};
		int[] b = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		
		System.out.println(m.minCostClimbingStairs(a));
		System.out.println(m.minCostClimbingStairs(b));
	}

}
