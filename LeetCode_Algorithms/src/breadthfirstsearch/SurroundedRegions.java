package breadthfirstsearch;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. Surrounded Regions
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if(board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        //process left right edge 0
        for(int i=0; i<m; i++) {
            if(board[i][0] == 'O') {
                bfs(i ,0, board);
            }
            if(board[i][n-1] == 'O') {
                bfs(i ,n-1, board);
            }
        }

        //process top bottom edge 0
        for(int j=0; j<n; j++) {
            if(board[0][j] == 'O') {
                bfs(0 ,j, board);
            }
            if(board[m-1][j] == 'O') {
                bfs(m-1 ,j, board);
            }
        }

        //post process set all ! to 0 and flip remain to x
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                if(board[i][j] == '!')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void bfs (int i, int j, char[][] board) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i , j));
        board[i][j] = '!';
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            if(x - 1 >=0 && board[x-1][y] == 'O'){
                queue.add(new Point(x-1, y));
                board[x-1][y] = '!';
            }

            if(x + 1 <= board.length-1 && board[x+1][y] == 'O'){
                queue.add(new Point(x+1, y));
                board[x+1][y] = '!';
            }

            if(y - 1 >= 0 && board[x][y-1] == 'O'){
                queue.add(new Point(x, y-1));
                board[x][y-1] = '!';
            }

            if(y + 1 <= board[0].length-1 && board[x][y+1] == 'O'){
                queue.add(new Point(x, y+1));
                board[x][y+1] = '!';
            }
        }
    }

    public static void main(String[] args) {
        char[][] b = new char[][]{
                {'X','x','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        new SurroundedRegions().solve(b);
    }
}
