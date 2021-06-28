package string;

import java.util.*;

public class AutocompleteSystem {

    TrieNode root;

    public AutocompleteSystem(String[] sentences, int[] times) {
        int n = sentences.length;
        sb = new StringBuilder();
        root = new TrieNode();
        curTrieNode = root;
        for(int i = 0; i < n; i ++) {
            build(sentences[i], times[i]);
        }
    }

    private void build(String sentence, int time) {
        TrieNode cur = root;
        for(char c : sentence.toCharArray()) {
            if(!cur.children.containsKey(c)) {
                TrieNode tNode = new TrieNode(c);
                cur.children.put(c, tNode);
            }
            //update current trie node,
            // if new sentence, add into map and add new node into sorted set with count
            //if existing sentence, find the node in set and update the it with count + 1
            TrieNode trieNode = cur.children.get(c);
            Pair sentence_count_pair;
            if(!trieNode.wordToNode.containsKey(sentence)) {
                sentence_count_pair = new Pair(sentence, time);
                trieNode.wordToNode.put(sentence, sentence_count_pair);
            } else {
                sentence_count_pair = trieNode.wordToNode.get(sentence);
                trieNode.set.remove(sentence_count_pair);
                sentence_count_pair.time += 1;
            }
            trieNode.set.add(sentence_count_pair);
            cur = cur.children.get(c);
        }
    }

    TrieNode curTrieNode;
    StringBuilder sb;
    public List<String> input(char c) {
        if(c != '#') {
            sb.append(c);
            //check if cur trie node has child node c, if not return empty list
            //otherwise get the top 3 sentences from current trie node
            if(!curTrieNode.children.containsKey(c)) {
                curTrieNode = new TrieNode();
                return new ArrayList<>();
            }
            List<String> top3 = curTrieNode.children.get(c).getTop(3);
            curTrieNode = curTrieNode.children.get(c);
            return top3;
        } else {
            build(sb.toString(), 1);
            curTrieNode = root;
            sb = new StringBuilder();
            return new ArrayList<>();
        }
    }

    class Pair implements Comparable<Pair> {
        String s;
        int time;

        public Pair(String s, int time) {
            this.s = s;
            this. time = time;
        }
        public int compareTo (Pair pair) {
            if(this.time != pair.time) {
                return Integer.compare(pair.time, this.time);
            }
            return this.s.compareTo(pair.s);
        }
    }

    class TrieNode {
        char c;
        Map<Character,TrieNode> children = new HashMap<>();
        TreeSet<Pair> set = new TreeSet<>();
        Map<String, Pair> wordToNode = new HashMap<>();
        int k = 3;

        public TrieNode () {}
        public TrieNode (char c) {
            this.c = c;
        }

        public List<String> getTop (int k) {
            List<String> res = new ArrayList<>();
            Iterator<Pair> iterator = this.set.iterator();
            int count = 0;
            while(iterator.hasNext() && count < k) {
                res.add(iterator.next().s);
                count ++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String[] s1 = new String[] {"i love you", "island", "iroman", "i love leetcode"};
        int[] t1 = new int[] {5 ,3 ,2, 2};
        AutocompleteSystem auto1 = new AutocompleteSystem(s1, t1);
        System.out.println(auto1.input('i'));
        System.out.println(auto1.input(' '));
        System.out.println(auto1.input('a'));
        System.out.println(auto1.input('#'));
    }
}
