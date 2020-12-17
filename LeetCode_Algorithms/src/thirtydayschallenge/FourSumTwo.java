package thirtydayschallenge;

import java.util.HashMap;
import java.util.Map;

public class FourSumTwo {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0) return 0;
        int n = A.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int i=0; i<n; i++) {
            for(int j= 0; j<n; j++) {
                int sum1 = A[i] + B[j];
                map1.put(sum1, map1.getOrDefault(sum1, 0) + 1);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j= 0; j<n; j++) {
                int sum2 = C[i] + D[j];
                map2.put(sum2, map2.getOrDefault(sum2, 0) + 1);
            }
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if(map2.containsKey(- entry.getKey()))
                count += entry.getValue() * map2.get(- entry.getKey());
        }
        return count;
    }

    public static void main (String[] args) {
        FourSumTwo f = new FourSumTwo();
        int[] a = new int[] {1,2};
        int[] b = new int[] {-2,-1};
        int[] c = new int[] {-1,2};
        int[] d = new int[] {0,2};
        System.out.println(f.fourSumCount(a, b, c, d));
    }
}
