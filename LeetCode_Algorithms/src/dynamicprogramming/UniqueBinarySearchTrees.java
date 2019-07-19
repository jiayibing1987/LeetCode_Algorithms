package dynamicprogramming;

public class UniqueBinarySearchTrees {

	/*
	 * For each bst, count for each number from 1...n as root node, how many possible left sub tree and possible right sub tree.Then multiple them.
	 * For example, n is 4,pick root node as 1, left sub tree is nothing and right sub tree is all possible bst for {2,3,4}which is same as {1,2,3},
	 * which is dp[3], so dp[n] is sum of dp[j-1]*dp[i-j] which j form 1 to i and i from 1 to n.
	 */
    public int numTrees(int n) {
    	if(n==1) return 1;
    	int[] dp = new int[n+1];
    	dp[0] = 1;
    	dp[1] = 1;
    	dp[2] = 2;
    	
    	for(int i=3; i<=n; i++){
    		for(int j=1; j<=i; j++){
    			dp[i] += dp[j-1] * dp[i-j];
    		}
    	}
    	return dp[n];
    }
    
	public static void main(String[] args) {
		UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
		System.out.println(u.numTrees(5));
	}

}
