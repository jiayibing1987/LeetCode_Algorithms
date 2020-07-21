package thirtydayschallenge;

public class WordSearch {

    boolean found = false;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0] && !found) {
                    dfs(visited, board, i, j, chars, 0);
                }
            }
        }
        return found;
    }

    private void dfs(boolean[][] visited, char[][] board, int i, int j, char[] chars, int index) {
        if(found) return;
        if (index >= chars.length) {
            found = true;
            return;
        }
        if(i < 0 || i >= board.length) return;
        if(j < 0 || j >= board[0].length) return;
        if (board[i][j] != chars[index]) return;
        if (visited[i][j]) return;

        visited[i][j] = true;
        dfs(visited, board, i - 1, j, chars, index + 1);
        dfs(visited, board, i + 1, j, chars, index + 1);
        dfs(visited, board, i, j - 1, chars, index + 1);
        dfs(visited, board, i, j + 1, chars, index + 1);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] a = {{'a', 'b'}, {'c', 'd'}};
        System.out.println(new WordSearch().exist(a, "cdba"));
    }
}
