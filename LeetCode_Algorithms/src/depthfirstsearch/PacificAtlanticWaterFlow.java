package depthfirstsearch;

import java.util.*;

public class PacificAtlanticWaterFlow {
    Set<List<Integer>> set = new HashSet<>();
    int m;
    int n;
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        if (n == 0) return res;

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = dfs(i, j, matrix, memo, new boolean[m][n]);
                if (temp == 3) {
                    set.add(List.of(i, j));
                }
                memo[i][j] = temp;
            }
        }

        res.addAll(set);
        return res;
    }

    //-1 not found, 0 not visited, 1 means ~, 2 means *, 3 means reach both sides
    private int dfs(int i, int j, int[][] matrix, int[][] memo, boolean[][] visited) {
        //if visited
        if (visited[i][j]) {
            return -1;
        }

        //if already proved can reach both sides
        if (set.contains(List.of(i, j))) {
            memo[i][j] = 3;
            return memo[i][j];
        }

        visited[i][j] = true;
        int top = i == 0 ? 1 : matrix[i][j] >= matrix[i-1][j] ? dfs(i - 1, j, matrix, memo, visited) : -1;
        int down = i == m-1 ? 2 :  matrix[i][j] >= matrix[i+1][j] ? dfs(i + 1, j, matrix, memo, visited) : -1;
        int left = j == 0 ? 1 : matrix[i][j] >= matrix[i][j-1] ? dfs(i, j - 1, matrix, memo, visited) : -1;
        int right = j == n -1 ? 2 : matrix[i][j] >= matrix[i][j+1] ? dfs(i, j + 1, matrix, memo, visited) : -1;

        Set<Integer> res = new HashSet<>();
        res.add(top); res.add(down); res.add(left); res.add(right);
        int answer;

        if (res.contains(3)) {
            answer = 3;
        } else if (res.contains(1) && res.contains(2)) {
            answer = 3;
        } else if (res.contains(1)) {
            answer = 1;
        } else if (res.contains(2)) {
            answer = 2;
        } else {
            answer = -1;
        }

        memo[i][j] = answer;
        if(answer == 3) set.add((List.of(i, j)));
        return answer;
    }

    public static void main (String[] args) {
        PacificAtlanticWaterFlow p = new PacificAtlanticWaterFlow();
        int[][] m = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int[][] m1 = {{10,10,10},
                      {10,1,10},
                     {10,10,10}};
        //System.out.println(p.pacificAtlantic(m));
        System.out.println(p.pacificAtlantic(m1));

    }
}
