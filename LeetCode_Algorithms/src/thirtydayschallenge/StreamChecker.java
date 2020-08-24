package thirtydayschallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StreamChecker {

    Queue<Trie> q;
    Trie root;
    public StreamChecker(String[] words) {
        root = new Trie();
        q = new LinkedList<>();
        q.add(root);
        for(String word : words) {
            addWord(word);
        }
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Trie cur = root;
        for(int i=0; i<chars.length; i++) {
            char c = chars[i];
            if(cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new Trie(c);
            }

            cur = cur.children[c-'a'];
            if(i == chars.length-1)
                cur.isLeaf = true;
        }
    }

    public boolean query(char letter) {
        boolean res = false;
        List<Trie> temp = new ArrayList<>();
        while(!q.isEmpty()) {
            Trie node = q.poll();
            if(node.children[letter-'a'] != null) {
                temp.add(node.children[letter-'a']);
                if(node.children[letter-'a'].isLeaf)
                    res = true;
            }
        }
        q.addAll(temp);
        q.add(root);
        return res;
    }

    public class Trie {
        char c;
        Trie[] children = new Trie[26];
        boolean isLeaf;
        public Trie() {}
        public Trie(char c) {this.c = c;}
    }

    public static void main(String[] args) {
        String[] words = {"cd", "f", "kl"};
        StreamChecker s = new StreamChecker(words);
        System.out.print(s.query('a') + " ");
        System.out.print(s.query('b') + " ");
        System.out.print(s.query('c') + " ");
        System.out.print(s.query('d') + " ");
    }

}
