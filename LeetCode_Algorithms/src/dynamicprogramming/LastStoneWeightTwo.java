package dynamicprogramming;


/**
 * 1049. Last Stone Weight II
 *
 * We have a collection of rocks, each rock has a positive integer weight.
 *
 * Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)
 */
public class LastStoneWeightTwo {

    //this question become split array into two subset s1 and s2,
    //find the min differences betweem s1 and s2, min(s1-s2)
    //in other word, find a subet set s1, find the largest value which sum(s1) smaller or equals to Sum/2.
    //return 2*(sum/2 - s1)
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int stone : stones)
            sum += stone;
        int halfSum = sum / 2;

        int[][] dp = new int[n+1][halfSum+1];
        for(int i=1; i<=n; i++) {
            int cur = stones[i-1];
            for(int j=0; j<=halfSum; j++) {
                if(j >= cur) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cur] + cur);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][halfSum];
        return sum - 2 * sum1;
    }
}
