package hashtable;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {

    public int subarraysDivByK(int[] A, int k) {
        int n = A.length;
        int[] prefix = new int[n];
        prefix[0] = A[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + A[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for(int i = 0; i < n; i++) {
            //p[x2] - p[x1] = k
            int key = prefix[i] % k;
            if(key < 0) key = k + key;
            if(map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return count;
    }

}
