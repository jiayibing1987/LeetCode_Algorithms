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
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		public TrieNode(){};
		public TrieNode(Character c){
			this.c = c;
		}
		boolean isLeaf;
	}
	
	TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    public boolean search(String word) {
        return this.helper(root, word, 0);
    }
    
    private boolean helper(TrieNode node, String word, int i){
    	if(i == word.length()){
    		return node.isLeaf;
    	}
    	char c = word.charAt(i);
    	if(c != '.'){
    		if(node.children.containsKey(c))
    			return helper(node.children.get(c), word, i+1);
    		else
        		return false;
    	}else{
    		for(TrieNode childNode : node.children.values()){
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
