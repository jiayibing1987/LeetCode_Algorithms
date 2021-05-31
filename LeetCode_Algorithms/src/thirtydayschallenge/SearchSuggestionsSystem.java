package thirtydayschallenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionsSystem {
    TrieNode root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new LinkedList<>();
        root = new TrieNode(' ');
        Arrays.sort(products);
        for(String word : products) {
            inert(word);
        }
        search(searchWord, res);
        return res;
    }

    public void search (String searchWord, List<List<String>> res) {
        TrieNode[] children = root.children;
        for(char c : searchWord.toCharArray()) {
            if(children != null && children[c - 'a'] != null) {
                TrieNode node = children[c - 'a'];
                List<String> suggestedWords = node.suggestedWords;
                res.add(suggestedWords);
                children = node.children;
            } else {
                children = null;
                res.add(new LinkedList<>());
            }
        }
    }

    public void inert (String word) {
        TrieNode[] children = root.children;
        for(char c : word.toCharArray()) {
            TrieNode node;
            if(children[c - 'a'] == null) {
                node = new TrieNode(c);
                children[c - 'a'] = node;
            } else {
                node = children[c - 'a'];
            }
            if(node.suggestedWords.size() < 3)
                node.suggestedWords.add(word);
            children = node.children;
        }
    }

    class TrieNode {
        char c;
        TrieNode[] children;
        List<String> suggestedWords;

        public TrieNode(){}
        public TrieNode(char c){
            this.c = c;
            children = new TrieNode[26];
            suggestedWords = new LinkedList<>();
        }
    }
}
