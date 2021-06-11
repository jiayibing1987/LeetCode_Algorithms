package dynamicprogramming;

public class StoneGameII {

    int[][] memo;
    int[] suffixSum;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        memo = new int[n][n];
        suffixSum = new int[n];
        int sum = 0;
        for(int i = n-1; i>=0; i--) {
            sum += piles[i];
            suffixSum[i] = sum;
        }
        return helper(piles, 0, 1);
    }

    private int helper(int[] a, int i, int m) {
        if(2 * m >= a.length - i)
            return suffixSum[i];

        if(i == a.length - 1) {
            return suffixSum[i];
        }

        if(memo[i][m] > 0) {
            return memo[i][m];
        }

        int min = Integer.MAX_VALUE;
        for(int x = 1; x <= 2 * m; x++) {
            int temp = helper(a, i + x, Math.max(x, m));
            if(temp < min) {
                min = temp;
            }
        }
        memo[i][m] = suffixSum[i] - min;
        return memo[i][m];
    }

    public static void main(String[] args) {
        StoneGameII s2 = new StoneGameII();
        int[] a1 = new int[] {6,4,2,8,1,8,6,6,2};
        System.out.println(s2.stoneGameII(a1));
    }
}
