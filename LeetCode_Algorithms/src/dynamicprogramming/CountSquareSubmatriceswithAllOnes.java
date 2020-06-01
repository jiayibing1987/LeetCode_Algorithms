package dynamicprogramming;

public class CountSquareSubmatriceswithAllOnes {

   public int countSquares(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        int res = dp[0][0];

        for(int i=1; i<m; i++) {
            dp[i][0] = matrix[i][0];
            res += dp[i][0];
        }
       for(int j=1; j<n; j++) {
           dp[0][j] = matrix[0][j];
           res += dp[0][j];
       }

       for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == 1)
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                res += dp[i][j];
            }
        }

       return res;
    }

    public static void main (String[] args) {
       int[][] a = new int[][]{{1,0,1},{1,1,0},{1,1,0}};
       System.out.println(new CountSquareSubmatriceswithAllOnes().countSquares(a));
    }

}
