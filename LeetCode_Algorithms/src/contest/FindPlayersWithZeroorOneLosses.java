package contest;

import java.util.*;

public class FindPlayersWithZeroorOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        int n = -1;

        Map<Integer, Integer> loserMap = new HashMap<>();
        Set<Integer> played = new HashSet<>();
        for(int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            played.add(winner);
            played.add(loser);
            loserMap.put(loser, loserMap.getOrDefault(loser, 0) + 1);
            n = Math.max(n, winner);
            n = Math.max(n, loser);
        }

        List<Integer> lostZero = new ArrayList<>();
        List<Integer> lostOne = new ArrayList<>();
        for(int i = 0; i <= n; i ++) {
            if(loserMap.containsKey(i) && loserMap.get(i) == 1) {
                lostOne.add(i);
            } else if (played.contains(i) && !loserMap.containsKey(i)) {
                lostZero.add(i);
            }
        }
        res.add(lostZero);
        res.add(lostOne);
        return res;
    }

    public static void main(String[] args) {

    }
}
