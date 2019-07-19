package hashtable;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			Set<Character> rowSet = new HashSet<Character>();
			Set<Character> columnSet = new HashSet<Character>();
			Set<Character> squareSet = new HashSet<Character>();
			for(int j=0; j<board.length; j++){
				int u = ((i/3) * 3) + (j%3);
				int v = ((i%3) * 3) + (j/3);
                 
                if ((rowSet.contains(board[i][j]))||
                    (columnSet.contains(board[j][i]))|| 
                    (squareSet.contains(board[u][v]))
                   ) return false; 
 
                if(board[i][j] != '.') rowSet.add(board[i][j]); 
                if(board[j][i] != '.') columnSet.add(board[j][i]); 
                if(board[u][v] != '.') squareSet.add(board[u][v]);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
