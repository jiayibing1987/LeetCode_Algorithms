package thirtydayschallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindtheTownJudge {

    public int findJudge(int N, int[][] trust) {
        if(trust == null || trust.length == 0) return N;
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<trust.length; i++){
            set.add(trust[i][0]);
            map.put(trust[i][1], map.getOrDefault(trust[i][1], 0) + 1);
            if(map.get(trust[i][1]) == N-1) res = trust[i][1];
        }
        return set.contains(res) ? -1 : res;
    }

}
