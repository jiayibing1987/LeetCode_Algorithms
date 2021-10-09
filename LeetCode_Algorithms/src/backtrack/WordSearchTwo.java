package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchTwo {
    TrieNode root;
    int m;
    int n;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0 , -1}};
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        root = new TrieNode(' ');
        for(String word : words)
            insert(word);

        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                dfs(board, visited, i, j, root, res, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs (char[][] board, boolean[][] visited, int r, int c,
                      TrieNode node, Set<String> res, String temp) {
        if(r >= m || r < 0 || c >= n || c < 0) {
            return;
        }
        if(visited[r][c]) {
            return;
        }

        char ch = board[r][c];
        if(node.children[ch - 'a'] == null) {
            return;
        }
        temp = temp + ch;

        node = node.children[ch - 'a'];
        if(node.isLeaf) {
            res.add(temp.trim());
        }

        visited[r][c] = true;
        for(int[] direction : directions) {
            int x = r + direction[0];
            int y = c + direction[1];
            dfs(board, visited, x, y, node, res, temp);
        }
        visited[r][c] = false;

    }

    private void insert(String s) {
        TrieNode cur = root;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TrieNode[] children = cur.children;
            if(children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode(c);
            }
            cur = children[c - 'a'];
        }
        cur.isLeaf = true;
    }

    class TrieNode {
        char c;
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;

        public TrieNode(char c) {
            this.c = c;
        }

        public String toString () {
            return c + " " + (isLeaf? "Leaf" : " ");
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{}, {}, {}, {}};
    }
}
