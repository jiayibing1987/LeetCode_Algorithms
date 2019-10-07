package breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * @author Ryan
 *
 */
public class NumberofIslands {

	// bfs
	public int numIslands1(char[][] grid) {
		if (grid.length == 0)
			return 0;
		int count = 0;
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] vistied = new boolean[row][col];
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!vistied[i][j] && grid[i][j] == '1') {
					count++;
					q.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int x = cur[0];
						int y = cur[1];
						if (x - 1 >= 0 && !vistied[x - 1][y] && grid[x - 1][y] == '1') {
							q.add(new int[] { x - 1, y });// up
							vistied[x - 1][y] = true;
						}
						if (x + 1 <= row - 1 && !vistied[x + 1][y] && grid[x + 1][y] == '1') {
							q.add(new int[] { x + 1, y });// down
							vistied[x + 1][y] = true;
						}
						if (y - 1 >= 0 && !vistied[x][y - 1] && grid[x][y - 1] == '1') {
							q.add(new int[] { x, y - 1 });// left
							vistied[x][y - 1] = true;
						}
						if (y + 1 <= col - 1 && !vistied[x][y + 1] && grid[x][y + 1] == '1') {
							q.add(new int[] { x, y + 1 });// right
							vistied[x][y + 1] = true;
						}
					}
				}
			}
		}
		return count;
	}

	// dfs
	public int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;
		int count = 0;
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] vistied = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(!vistied[i][j] && grid[i][j] == '1'){
					count ++;
					dfs(grid, vistied, i, j);
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, boolean[][] vistied, int i, int j) {
		if( i<0 || i == grid.length || j< 0 || j == grid[0].length || vistied[i][j] || grid[i][j] == '0' )
			return ;
		vistied[i][j] = true;
		dfs(grid, vistied, i-1, j);
		dfs(grid, vistied, i+1, j);
		dfs(grid, vistied, i, j-1);
		dfs(grid, vistied, i, j+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
