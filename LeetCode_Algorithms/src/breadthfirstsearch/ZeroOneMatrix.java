package breadthfirstsearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    int m;
    int n;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], m * n);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    memo[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }
        bfs(mat, memo, new boolean[m][n], q);
        return memo;
    }

    private void bfs(int[][] mat, int[][] memo, boolean[][] visited, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for (int[] direction : directions) {
                int x = r + direction[0];
                int y = c + direction[1];
                if (x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == 1 && !visited[x][y]) {
                    if (memo[r][c] + 1 < memo[x][y]) {
                        visited[x][y] = true;
                        memo[x][y] = memo[r][c] + 1;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ZeroOneMatrix z = new ZeroOneMatrix();
        int[][] m1 = new int[][]{{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}};
        System.out.println(z.updateMatrix(m1));
    }
}
