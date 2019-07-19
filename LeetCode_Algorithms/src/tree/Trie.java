package tree;

import java.util.HashMap;
import java.util.Map;

/*
 * 208. Implement Trie (Prefix Tree)
 */
public class Trie {

	class TrieNode{
		char c;
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isLeaf;
		public TrieNode(){}
		public TrieNode(char c){
			this.c = c;
		}
	}

	TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Map<Character, TrieNode> children = root.children;
        for(int i=0; i<word.length(); i++){
        	char c = word.charAt(i);
        	TrieNode node;
        	if(children.containsKey(c)){
        		node = children.get(c);
        	}else{
        		node = new TrieNode(c);
        		children.put(c, node);
        	}
        	children = node.children;
        	if(i==word.length()-1)
        		node.isLeaf = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Map<Character, TrieNode> children = root.children;
        for(int i=0; i<word.length(); i++){
        	char c = word.charAt(i);
        	TrieNode node;
        	if(children.containsKey(c)){
        		node = children.get(c);
        	}else{
        		return false;
        	}
        	children = node.children;
        	if(i==word.length()-1 && node.isLeaf){
        		return true;
        	}
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       	Map<Character, TrieNode> children = root.children;
        for(int i=0; i<prefix.length(); i++){
        	char c = prefix.charAt(i);
        	TrieNode node;
        	if(children.containsKey(c)){
        		node = children.get(c);
        	}else{
        		return false;
        	}
        	children = node.children;
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
