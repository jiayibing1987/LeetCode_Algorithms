package thirtydayschallenge;

/**
 *  Unique Binary Search Trees
 *
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        //let for number i, let j(j<=i) is root node, res = left part * right part
        //               j
        // 1,.. j-2,j-1     j+1, j+2... i
        for(int i=2; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
