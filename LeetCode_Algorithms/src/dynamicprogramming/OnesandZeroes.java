package dynamicprogramming;

public class OnesandZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] dp = new int[l+1][m+1][n+1];

        for(int k=1; k<=l; k++) {
            int[] cur = calc(strs[k-1]);
            for(int i=0; i<=m; i++) {
                for(int j=0; j<=n; j++) {
                    if(i>=cur[0] && j>= cur[1])
                        dp[k][i][j] = Math.max(dp[k-1][i][j], dp[k-1][i-cur[0]][j-cur[1]] + 1);
                    else
                        dp[k][i][j] = dp[k-1][i][j];
                }
            }
        }
        return dp[l][m][n];
    }

    public int[] calc(String s) {
        int[] res = new int[2];
        int count_zero = 0;
        int count_one = 0;
        for(char c : s.toCharArray()) {
            if(c == '0')
                count_zero++;
            else if(c == '1')
                count_one++;
        }
        return new int[]{count_zero, count_one};
    }

    public static void main(String[] args) {
        OnesandZeroes o = new OnesandZeroes();
        String[] strs1 = {"10","0001","111001","1","0"};
        String[] strs2 = {"10","0","1"};
        System.out.println(o.findMaxForm(strs1, 5, 3));
       // System.out.println(o.findMaxForm(strs2, 1, 1));
    }
}
