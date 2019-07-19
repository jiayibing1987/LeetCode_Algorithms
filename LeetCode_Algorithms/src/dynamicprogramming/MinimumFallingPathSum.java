package dynamicprogramming;

import java.util.Arrays;

/**
 * #931 
 * @author Ryan
 *
 */
public class MinimumFallingPathSum {

	//dp[i][j] is the min path sum that start from A[i][j] to the bottom of the matrix.
	//dp[i][j] = Math.min(dp[i+1][j-1], dp[i+1][j], dp[i+1][j+1])
    public int minFallingPathSum(int[][] A) {
    	if(A.length == 0) return 0;
    	int row = A.length;
    	int col = A[0].length;
    	int[][] dp = new int[row+1][col];
    	for(int i=row-1; i>=0; i--){
    		for(int j=0; j<col; j++){
    			int a, b ,c;
    			if(j-1 < 0) a = Integer.MAX_VALUE; else a = dp[i+1][j-1];
    			if(j+1 > col-1) c = Integer.MAX_VALUE; else c = dp[i+1][j+1];
    			b = dp[i+1][j];
    			dp[i][j] = A[i][j] + Math.min(a, Math.min(b, c));	
    		}
    	}
    	int res = Integer.MAX_VALUE;
    	for(int n: dp[0]){
    		res = Math.min(res, n);
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		MinimumFallingPathSum m = new MinimumFallingPathSum();
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(m.minFallingPathSum(a));
	}

}
