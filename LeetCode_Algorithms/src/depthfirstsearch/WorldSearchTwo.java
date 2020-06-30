package depthfirstsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. Word Search II
 */
public class WorldSearchTwo {

    class TrieNode {
        Character c;
        TrieNode[] children = new TrieNode[26];
        String word;
        TrieNode(Character c) {
            this.c = c;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> results = new HashSet<>();
        if(board == null || board.length == 0 || board[0].length == 0)
            return new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        TrieNode root = new TrieNode(null);
        //set up trie
        for(String word : words) {
            add(root, word);
        }
        //dfs board
        boolean[][] visited = new boolean[m][n];
        for(int i= 0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dfs(board, i, j, root, visited, results);
            }
        }
        return new ArrayList<>(results);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, boolean[][] visited, Set<String> results) {
        char c = board[i][j];
        TrieNode[] children = node.children;

        if(visited[i][j]) return;
        if(children[c-'a'] == null) return;

        node = children[c-'a'];


        if(node.word != null){
            results.add(node.word);
        }

        visited[i][j] = true;
        if(i > 0) dfs(board, i-1, j, node, visited, results);
        if(j > 0) dfs(board, i, j-1, node, visited, results);
        if(i < board.length-1) dfs(board, i+1, j, node, visited, results);
        if(j < board[0].length-1) dfs(board, i, j+1, node, visited, results);
        visited[i][j] = false;
    }


    public void add(TrieNode root, String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            TrieNode[] children = node.children;
            if(children[c-'a'] == null) {
                children[c-'a'] = new TrieNode(c);
            }
            node = children[c-'a'];
            if(i == word.length()-1)
                node.word = word;
        }
    }


}
