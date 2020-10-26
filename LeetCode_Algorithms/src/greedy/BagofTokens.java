package greedy;

import java.util.Arrays;

public class BagofTokens {

    public int bagOfTokensScore(int[] tokens, int P) {
        int n = tokens.length;
        if(n == 0 || P <= 0) return 0;
        Arrays.sort(tokens);

        int score = 0, power = P;
        int low = 0;
        int high = n-1;
        while(low <= high) {
            if(power < tokens[low] ) {
                if(score > 0 && low != high) {
                    power += tokens[high--];
                    score--;
                } else {
                    break;
                }
            } else {
                score ++;
                power -= tokens[low ++];
            }

        }
        return score;
    }

}
