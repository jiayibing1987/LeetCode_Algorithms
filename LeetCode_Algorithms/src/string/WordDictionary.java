package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 211. Add and Search Word - Data structure design
 * @author Ryan
 *
 */
public class WordDictionary {

	class TrieNode{
		Character c;
		TrieNode[] children = new TrieNode[26];
		public TrieNode(){};
		public TrieNode(Character c){
			this.c = c;
		}
		boolean isLeaf;
	}
	
	TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
    	TrieNode[] children = root.children;
        for(int i=0; i<word.length(); i++){
        	char c = word.charAt(i);
        	TrieNode node;
        	if(children[c-'a'] == null)
        		children[c-'a'] = new TrieNode(c);
    		node = children[c-'a'] ;

        	children = node.children;
        	if(i==word.length()-1)
        		node.isLeaf = true;
        }
    }
    
    public boolean search(String word) {
        return this.helper(root, word, 0);
    }
    
    private boolean helper(TrieNode node, String word, int i){
    	if(i == word.length()){
    		return node.isLeaf;
    	}
    	char c = word.charAt(i);
    	if(c != '.'){
    		if(node.children[c-'a'] != null)
    			return helper(node.children[c-'a'], word, i+1);
    		else
        		return false;
    	}else{
    		for(TrieNode childNode : node.children){
    			if(childNode == null) continue;
    			if(helper(childNode, word, i+1))
    				return true;
    		}
    		return false;
    	}
    } 
    
	public static void main(String[] args) {
		WordDictionary dic = new WordDictionary();
		dic.addWord("a");
		dic.addWord("ab");
		//dic.addWord("mad");
		System.out.println(dic.search("a"));
		System.out.println(dic.search("a."));
		System.out.println(dic.search(".ad"));
		System.out.println(dic.search("b.."));
		System.out.println(dic.search(""));
		System.out.println(dic.search("."));

	}

}
