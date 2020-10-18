package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTeamWithNoConflicts {

    public int bestTeamScore(int[] scores, int[] ages) {
        int max = 0;
        int n = scores.length;
        Player[] players = new Player[n];
        for(int i=0; i<n; i++) {
            players[i] = new Player(ages[i], scores[i]);
        }
        Arrays.sort(players, (a, b) -> a.age != b.age ? a.age - b.age : a.score - b.score);

        int[] dp = new int[n];
        for(int i=n-1; i>=0; i--){
            dp[i] = players[i].score;
            for(int j=n-1; j>i; j--) {
                if(players[j].score >= players[i].score)
                    dp[i] = Math.max(dp[i], dp[j] + players[i].score);
            }
        }

        for(int x : dp)
            max = Math.max(x, max);
        return max;
    }

    public class Player {
        int age;
        int score;

        public Player(int a, int s) {
            this.age = a;
            this.score = s;
        }
    }

    public static void main(String[] args) {
        BestTeamWithNoConflicts b = new BestTeamWithNoConflicts();
        int[] s1 = new int[] {1,3,5,10,15};
        int[] a1 = new int[] {1,2,3,4,5};
        System.out.println(b.bestTeamScore(s1, a1));

        int[] s2 = new int[] {4,5,6,5};
        int[] a2 = new int[] {2,1,2,1};
        System.out.println(b.bestTeamScore(s2, a2));

        int[] s3 = new int[] {9,2,8,8,2};
        int[] a3 = new int[] {4,1,3,3,5};
        System.out.println(b.bestTeamScore(s3, a3));
    }

}
