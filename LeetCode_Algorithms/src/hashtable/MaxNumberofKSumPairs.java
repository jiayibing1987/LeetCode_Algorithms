package hashtable;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberofKSumPairs {

    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            if(map.containsKey(k - n)) {
                if(map.get(k-n) == 1) {
                    map.remove(k-n);
                }else {
                    map.put(k-n, map.get(k-n) - 1);
                }
                count++;
            } else {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }
        return count;
    }


}
