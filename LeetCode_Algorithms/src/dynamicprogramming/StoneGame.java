package dynamicprogramming;

public class StoneGame {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int sum = 0;
        for (int p : piles) {
            sum += p;
        }
        int[][] dp = new int[n][n];

        for (int diff = 1; diff <= n - 1; diff = diff + 2) {
            for (int i = n - 1 - diff; i >= 0; i--) {
                int j = i + diff;
                if (diff == 1) {
                    dp[i][j] = Math.max(piles[i], piles[j]);
                } else {
                    //case1: pick i
                    //i || i+1 i+2........j-1 j
                    //compare i+1 and j, for player B always pick the larger number here
                    int pickI = (piles[i + 1] > piles[j] ? dp[i + 2][j] : dp[i + 1][j - 1]) + piles[i];
                    //case2: pick j
                    //i i+1 ........j-2 j-1 || j
                    //compare i and j - 1, for player B always pick the larger number here
                    int pickJ = (piles[i] > piles[j - 1] ? dp[i + 1][j - 1] : dp[i][j - 2])  + piles[j];
                    dp[i][j] = Math.max(pickI, pickJ);
                }
            }
        }

        return dp[0][n - 1] > (sum / 2);
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{3,7,2,3};
        StoneGame s = new StoneGame();
        System.out.println(s.stoneGame(a1));

        int[] a2 = new int[]{5, 2, 10, 6};
        //System.out.println(s.stoneGame(a2));
    }
}
