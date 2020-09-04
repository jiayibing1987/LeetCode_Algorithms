package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        int count = 1;
        int curEnd = 0;
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            curEnd = Math.max(map.get(c), curEnd);
            if(i == curEnd) {
                res.add(count);
                count = 1;
            } else {
                count ++;
            }
        }
        return res;
    }

}
