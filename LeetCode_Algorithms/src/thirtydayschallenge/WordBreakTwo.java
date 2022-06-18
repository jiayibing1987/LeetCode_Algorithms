package thirtydayschallenge;

import java.util.ArrayList;
import java.util.List;

public class WordBreakTwo {

    Trie root;
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        for(String word : wordDict) {
            addWord(word);
        }

        backTrack(s, root, "", 0);
        return res;
    }

    private void backTrack(String s, Trie node, String temp, int start) {
        if(start == s.length())
            return;

        Trie cur = node;
        for(int i = start; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(cur.children[c - 'a'] != null) {
                if(cur.children[c - 'a'].isLeaf) {
                    String newS = temp + s.substring(start, i + 1);
                    if(i == s.length() - 1) {
                        res.add(newS);
                        return;
                    }
                    backTrack(s, root, newS + " ", i + 1 );
                }
                cur = cur.children[c - 'a'];
            } else {
                return;
            }
        }
    }

    public void addWord(String word) {
        Trie cur = root;
        for(int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new Trie(c);
            cur = cur.children[c - 'a'];
            if(i == word.length() - 1)
                cur.isLeaf = true;
        }
    }

    static class Trie {
        char c;
        boolean isLeaf;
        Trie[] children = new Trie[26];
        public Trie () {}
        public Trie (char c) { this.c = c; }
    }

    public static void main(String[] args) {
        WordBreakTwo wb = new WordBreakTwo();
        //System.out.println(wb.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
        System.out.println(wb.wordBreak("cbca", List.of("bc","ca")));

    }
}
