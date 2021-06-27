package contest;

public class CyclicallyRotatingaGrid {

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int row = m;
        int col = n;


        for(int i = 0; row >= 2 && col >= 2; row -= 2, col -= 2, i++) {
            int total = 2 * row + 2 * col - 4;
            int moves = k % total;
            int[][] cur = grid;
            while(moves > 0) {
                int[][] temp = new int[m][m];
                for(int r = i, c = i; r < i + row - 1; r ++) {
                    temp[r+1][c] = cur[r][c];
                }

                for(int r = i + row - 1, c = i; c < i + col - 1; c ++) {
                    temp[r][c+1] = cur[r][c];
                }

                for(int r = i+ row - 1, c = i + col - 1; r > i ; r--) {
                    temp[r-1][c] = cur[r][c];
                }

                for(int r = i, c = i + col - 1; c > i; c--) {
                    temp[r][c-1] = cur[r][c];
                }

                cur = temp;
                moves --;
            }
            copy(grid, cur);
        }
        return grid;
    }

    private void copy(int[][] grid, int[][] temp) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(temp[i][j] != 0)
                    grid[i][j] = temp[i][j];
            }
        }
    }

    public static void main(String[] args) {
        CyclicallyRotatingaGrid c = new CyclicallyRotatingaGrid();
        c.rotateGrid(new int[][] {{40,10}, {30,20}}, 2);
    }
}
