package dynamicprogramming;

/*
 * #264
 */
public class UglyNumberTwo {

	/*
	 * Essentially, we have to multiply the existed ugly numbers by 2, 3 and 5 to get a bigger ugly number,
	 * however, if we blindly multiply all the existed numbers by 2, 3 and 5, 
	 * then the number could grow much faster than needed
	 * Hence, every time we only try to find the next smallest ugly number
	 * Also, since any existed number will be multiplied by 2, 3 and 5 once and only once, otherwise duplicate, we can use a pointer to keep track of where the 2, 3 and 5 are going to multiply in the next step.
	 * Once, we find the next minimum, we can move on the corresponding pointer, otherwise it always stays at the already existed ugly number
	 */
    public int nthUglyNumber(int n) {
    	int[] dp = new int[n+1];
    	dp[1] = 1;
    	int p2 = 1; int p3 = 1; int p5 = 1;
    	for(int i=2; i<=n; i++){
    		dp[i] = Math.min(dp[p2]*2, Math.min(dp[p3]*3, dp[p5]*5));
    		if(dp[i] == dp[p2]*2) p2++;
    		if(dp[i] == dp[p3]*3) p3++;
    		if(dp[i] == dp[p5]*5) p5++;
    	}
    	return dp[n];
    }
    
    
	public static void main(String[] args) {
		UglyNumberTwo u = new UglyNumberTwo();
		for(int i=1; i<=10; i++){
			System.out.println(u.nthUglyNumber(i));
		}
	}

}
