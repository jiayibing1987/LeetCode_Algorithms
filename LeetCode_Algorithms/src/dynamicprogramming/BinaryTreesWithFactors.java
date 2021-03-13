package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreesWithFactors {

    public int numFactoredBinaryTrees(int[] arr) {
        int m = 1000000000 + 7;
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        Arrays.fill(dp, 1L);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            map.put(arr[i], i);

        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] % arr[j] == 0) {
                    if(map.containsKey(arr[i] / arr[j])) {
                        int k = map.get(arr[i] / arr[j]);
                        dp[i] += dp[j] * dp[k];
                        dp[i] = dp[i] % m;
                    }
                }
            }
            sum += dp[i];
        }
        return sum;
    }

    public static void main (String[] args) {
        BinaryTreesWithFactors b = new BinaryTreesWithFactors();
        System.out.println(b.numFactoredBinaryTrees(new int[] {2,4,5,10}));
    }
}
