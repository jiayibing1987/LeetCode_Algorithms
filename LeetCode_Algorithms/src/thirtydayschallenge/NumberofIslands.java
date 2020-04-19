package thirtydayschallenge;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n==0) return 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair<Integer, Integer>> q = new LinkedList<Pair<Integer, Integer>>();
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]){
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                    bfs(m, n, grid, visited, q);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs (int m, int n, char[][] grid, boolean[][] visited, Queue<Pair<Integer, Integer>> q){
        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            int i = p.getKey();
            int j = p.getValue();

            if(i-1 >=0 && grid[i-1][j] == '1' && !visited[i-1][j]) {
                q.add(new Pair(i - 1, j));
                visited[i-1][j] = true;
            }
            if(i+1 <= m-1 && grid[i+1][j] == '1' && !visited[i+1][j]) {
                q.add(new Pair(i + 1, j));
                visited[i+1][j] = true;
            }
            if(j-1>=0 && grid[i][j-1] == '1' && !visited[i][j-1]) {
                q.add(new Pair(i, j - 1));
                visited[i][j-1] = true;
            }
            if(j+1<=n-1 && grid[i][j+1] == '1' && !visited[i][j+1]) {
                q.add(new Pair(i, j + 1));
                visited[i][j+1] = true;
            }
        }
    }

    public static void main (String[] args) {
        char[][] g = new char[][] {{'1','1','1'},{'0','1','0'},{'0','1','0'}};
        System.out.print(new NumberofIslands().numIslands(g));
    }
}
