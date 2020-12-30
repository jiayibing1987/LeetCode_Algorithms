package array;

public class GameofLife {

    /**
     * 1 is live cell, 2 is dead cell which transferred from live cell 1
     * 0 is dead cell, -1 is live cell which transferred from dead cell 0
     */
    int m;
    int n;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 1)
                    applyLiveCellRule(board, i, j);
                else
                    applyDeadCellRule(board, i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if (board[i][j] == -1)
                    board[i][j] = 1;
            }
        }

    }

    //Any live cell with fewer than two live neighbors dies as if caused by under-population.
    //Any live cell with two or three live neighbors lives on to the next generation.
    //Any live cell with more than three live neighbors dies, as if by over-population.
    private void applyLiveCellRule(int[][] board, int i, int j) {
        int count = getLiveNeighbours(board, i, j);
        if(count < 2)
            board[i][j] = 2;
        else if (count > 3)
            board[i][j] = 2;
    }

    //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    private void applyDeadCellRule(int[][] board, int i, int j) {
        int count = getLiveNeighbours(board, i, j);
        if(count == 3)
            board[i][j] = -1;
    }

    private int getLiveNeighbours(int[][] board, int i, int j) {
        int count = 0;
        if (i > 0 && j > 0 && board[i - 1][j - 1] >= 1)
            count++;
        if (i > 0 && board[i - 1][j] >= 1)
            count++;
        if (i > 0 && j < n - 1 && board[i - 1][j + 1] >= 1)
            count++;

        if (j > 0 && board[i][j - 1] >= 1)
            count++;
        if (j < n - 1 && board[i][j + 1] >= 1)
            count++;

        if (i < m - 1 && j > 0 && board[i + 1][j - 1] >= 1)
            count++;
        if (i < m - 1 && board[i + 1][j] >= 1)
            count++;
        if (i < m - 1 && j < n - 1 && board[i + 1][j + 1] >= 1)
            count++;

        return count;
    }

}
