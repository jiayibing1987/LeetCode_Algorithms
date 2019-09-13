package dynamicprogramming;

/**
 * 221. Maximal Square
 * @author Ryan
 *
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
    	if(matrix.length == 0) return 0;
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int[][] dp = new int[row][col];
    	int max = 0;
    	for(int i=0; i<row; i++){
    		dp[i][0] = Character.getNumericValue(matrix[i][0]);
    		if(matrix[i][0] == '1') max = 1;
    	}
    	for(int j=0; j<col; j++){
    		dp[0][j] = Character.getNumericValue(matrix[0][j]);
    		if(matrix[0][j] == '1') max = 1;
    	}
    	
    	for(int i=1; i<row;i++){
    		for(int j=1; j<col; j++){
    			if(matrix[i][j] == '0') continue;
    			dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
    			max = Math.max(max, dp[i][j]*dp[i][j]);
    		}
    	}
		return max;
    }
    
    
	public static void main(String[] args) {
		MaximalSquare ms = new MaximalSquare();
		char[][] matrix = {{'1'}};
		System.out.print(ms.maximalSquare(matrix));
	}

}
