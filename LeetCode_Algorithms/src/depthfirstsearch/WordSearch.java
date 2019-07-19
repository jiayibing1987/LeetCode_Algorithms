package depthfirstsearch;

public class WordSearch {

	boolean[][] visited;
	public boolean exist(char[][] board, String word) {
		if (word == null || word.isEmpty())
			return true;
		if (board == null)
			return false;
		char[] chars = word.toCharArray();
		visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == chars[0]) {
					if (dfs(board, chars, i, j, 0))
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, char[] chars, int i, int j, int start) {
		if (start >= chars.length)
			return true;
		if (i < 0 || i > board.length - 1)
			return false;
		if (j < 0 || j > board[0].length - 1)
			return false;
		if (board[i][j] != chars[start]) // not found the target char 
			return false;
		if(visited[i][j])
			return false;

		visited[i][j] = true;
		boolean result = dfs(board, chars, i + 1, j, start + 1) || dfs(board, chars, i - 1, j, start + 1)
				|| dfs(board, chars, i, j + 1, start+1) || dfs(board, chars, i, j - 1, start+1);
		visited[i][j] = false;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
