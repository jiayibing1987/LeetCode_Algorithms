package thirtydayschallenge;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    class Node {
        Character c;
        Map<Character, Node> children = new HashMap<>();
        boolean isLeaf;
        Node(){}
        Node (char c) {
            this.c = c;
        }
    }

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
        root.isLeaf = true;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) {
                Node child = new Node(c);
                cur.children.put(c, child);
                cur = child;
            }else {
                cur = cur.children.get(c);
            }
        }
        cur.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.children.containsKey(c))
                return false;
            else {
                cur = cur.children.get(c);
            }
        }
        return cur.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(!cur.children.containsKey(c))
                return false;
            else {
                cur = cur.children.get(c);
            }
        }
        return true;
    }

}
