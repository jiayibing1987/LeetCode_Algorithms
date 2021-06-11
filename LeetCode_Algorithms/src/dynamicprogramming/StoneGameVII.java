package dynamicprogramming;

public class StoneGameVII {

    int[] prefixSum;

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        prefixSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
            prefixSum[i] = sum;
        }

        Pair[][] dp = new Pair[n][n];

        int diff = (n % 2 == 0) ? 1 : 0;
        for (; diff <= n - 1; diff = diff + 2) {
            for (int i = n - 1 - diff; i >= 0; i--) {
                int j = i + diff;
                if(i == j) {
                    dp[i][j] = new Pair(0, 0);
                    continue;
                }
                if (diff == 1) {
                    dp[i][j] = new Pair(Math.max(stones[i], stones[j]), 0);
                } else {
                    //case1: player A pick i
                    //i || i+1 i+2........j-1 j
                    //compare i+1 and j, for player B always pick the smaller number here
                    //int pickI = (stones[i + 1] < stones[j] ? dp[i + 2][j].x : dp[i + 1][j - 1].x) + getScore(i, j, i);
                    Pair pickI;
                    {
                        //given sub array i+1 tp j, player B pick i+1 here
                        int playerB1 = dp[i + 2][j].y + getScore(i + 1, j, i + 1);
                        int playerA1 = dp[i + 2][j].x + getScore(i, j, i);

                        //given sub array i+1 tp j, player B pick j here
                        int playerB2 = dp[i + 1][j - 1].y + getScore(i + 1, j, j);
                        int playerA2 = dp[i + 1][j - 1].x + getScore(i, j, i);

                        pickI = playerA1 - playerB1 < playerA2 - playerB2 ? new Pair(playerA1, playerB1) : new Pair(playerA2, playerB2);
                    }
                    //case2: player A pick j
                    //i i+1 ........j-2 j-1 || j
                    //compare i and j - 1, for player B always pick the smaller number here
                    //int pickJ = (stones[i] < stones[j - 1] ? dp[i + 1][j - 1] : dp[i][j - 2]) + getScore(i, j, j);
                    Pair pickJ;
                    {
                        //given sub array i tp j-1, player B pick i here
                        int playerB1 = dp[i + 1][j - 1].y + getScore(i, j - 1, i);
                        int playerA1 = dp[i + 1][j - 1].x + getScore(i, j, j);

                        //given sub array i tp j-1, player B pick j-1 here
                        int playerB2 = dp[i][j-2].y + getScore(i, j-1, j-1);
                        int playerA2 = dp[i][j-2].x + getScore(i, j, j);

                        pickJ = playerA1 - playerB1 < playerA2 - playerB2 ? new Pair(playerA1, playerB1) : new Pair(playerA2, playerB2);
                    }
                    dp[i][j] = pickI.x - pickI.y > pickJ.x - pickJ.y ? pickI : pickJ;
                }
            }
        }
        return dp[0][n - 1].x - dp[0][n - 1].y;
    }

    private int getScore(int i, int j, int select) {
        if (select == i) { // from i +1 to j
            return prefixSum[j] - prefixSum[i];
        } else if (select == j) { //from i to j - 1
            return prefixSum[j - 1] - (i == 0 ? 0 : prefixSum[i - 1]);
        } else {
            System.out.println("error when select number");
            return -1;
        }
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        StoneGameVII st = new StoneGameVII();
        int[] a1 = new int[] {5,3,1,4,2};
        //System.out.println(st.stoneGameVII(a1));

        int[] a2 = new int[] {7,90,5,1,100,10,10,2};
        System.out.println(st.stoneGameVII(a2));
    }

}
