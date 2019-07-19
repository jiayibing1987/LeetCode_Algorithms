package dynamicprogramming;


/**
 * #486
 * @author Ryan
 *
 */
public class PredicttheWinner {

    public boolean PredictTheWinner(int[] nums) {
    	int n = nums.length;
    	if(n<=2) return true;
    	int sum = 0;
    	for(int i=0; i<n; i++)
    		sum += nums[i];
    	//dp[i][j] is the max value that for player A choose if index i to j number left
    	//dp[i][j] = max(a[i] + a[i+1][j], a[j] + a[i][j-1])
    	//but there is another player who play the optimum way as player A, we need to consider worst case
    	//after play A pick a[i], player B may pick a[i+1] or a[j] to maximum his value
    	//is Player B pick a[j], next step for player A is dp[i+1][j-1] + a[i] or player B pick a[i+1], player A then dp[i+2][j]
    	//dp[i][j] = min(dp[i+1][j-1], dp[i+2][j]) + a[i], min because player max his value means min player A value
    	// Similar if player pick a[j], dp[i][j] = min(dp[i+1][j-1], dp[i][j-2]) + a[j], and finally do[i][j] is max of those above
    	int[][] dp = new int[n][n];
    	for(int i=0; i<n; i++)
    		dp[i][i] = nums[i];	
    	for(int i=0; i<n-1; i++)
    		dp[i][i+1] = Math.max(nums[i], nums[i+1]);
    		
    	for(int i=n-3; i>=0; i--){
    		for(int j=i+2; j<=n-1; j++){
    			dp[i][j] = Math.max(Math.min(dp[i+1][j-1], dp[i+2][j]) + nums[i], 
    					Math.min(dp[i+1][j-1], dp[i][j-2]) + nums[j]);
    		}
    	}
    	return 2*dp[0][n-1] >= sum;
    }	
	
	public static void main(String[] args) {
		PredicttheWinner p = new PredicttheWinner();
		int[] a = {1,5,2};
		int[] b = {1,5,233,7};
		System.out.println(p.PredictTheWinner(b));
	}

}
