package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class NumberofSubmatricesThatSumtoTarget {

    int m, n;

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        //set prefix sum for matrix
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                pre[r][c] = pre[r - 1][c] + pre[r][c - 1] - pre[r - 1][c - 1] + matrix[r - 1][c - 1];
            }
        }

        Map<Integer, Integer> map;
        int count = 0;
        for (int r1 = 1; r1 <= m; r1++) {
            for (int r2 = r1; r2 <= m; r2++) {
                map = new HashMap<>();
                map.put(0, 1);
                for (int c = 1; c <= n; c++) {
                    //get cur sum
                    int curSum = pre[r2][c] - pre[r1 - 1][c];

                    //curSum - want = target (sum of a sub_matrix )
                    int want = curSum - target;
                    if (map.containsKey(want)) {
                        count += map.get(want);
                    }
                    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
                }
            }
        }

        return count;
    }
}
