package thirtydayschallenge;

public class WordDictionary {

    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Trie cur = root;
        for(int i=0; i<word.length(); i++) {
            if(cur.nodes[chars[i]-'a'] == null )
                cur.nodes[chars[i]-'a'] = new Trie(chars[i]);

            cur = cur.nodes[chars[i]-'a'];
            if(i == word.length()-1) cur.isLeaf = true;

        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.isEmpty()) return false;
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] chars, int index, Trie cur) {
        if(index == chars.length)
            return cur.isLeaf;

        if(chars[index] != '.') {
            if(cur.nodes[chars[index] - 'a'] == null)
                return false;
            else
                return dfs(chars, index+1, cur.nodes[chars[index] - 'a']);
        }else {
            boolean res = false;
            for(int i=0; i<26; i++) {
                if(cur.nodes[i] != null)
                    res = res || dfs(chars, index + 1, cur.nodes[i]);
            }
            return res;
        }
    }

    class Trie {
        Character c;
        boolean isLeaf;
        Trie[] nodes = new Trie[26];
        Trie(){}
        Trie(char c){
            this.c = c;
        }
    }

    public static void main(String[] args) {
        thirtydayschallenge.WordDictionary dic = new thirtydayschallenge.WordDictionary();
        dic.addWord("a");
        dic.addWord("ab");

        System.out.println(dic.search("a"));
        System.out.println(dic.search("a."));
        System.out.println(dic.search("ab"));
        System.out.println(dic.search(".a"));
        System.out.println(dic.search(".b"));

        System.out.println(dic.search("ab."));
        System.out.println(dic.search(".."));
        System.out.println(dic.search("."));
    }

}
