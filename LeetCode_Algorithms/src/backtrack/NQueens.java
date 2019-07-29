package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N-Queens
 * @author Ryan
 *
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    
	private void dfs(char[][] board, int rowIndex, List<List<String>> res) {
		if(rowIndex == board.length){
			res.add(construct(board));
			return;
		}
		for(int j=0; j<board.length; j++){
			if(!validate(board, rowIndex, j)) continue;
			board[rowIndex][j] = 'Q';
			dfs(board, rowIndex+1, res);
			board[rowIndex][j] = '.';
		}
	}

    private boolean validate(char[][] board, int x, int y) {
    	for(int i=0; i<board.length; i++){
    		for(int j=0; j<board.length; j++){
    			if(board[i][j]== 'Q' && (Math.abs(x-i)== Math.abs(y-j)|| y==j)){
    				return false;
    			}
    		}
    	}
    	return true;
	}

	private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
	public static void main(String[] args) {
		NQueens n = new NQueens();
		System.out.println(n.solveNQueens(4));
	}

}
