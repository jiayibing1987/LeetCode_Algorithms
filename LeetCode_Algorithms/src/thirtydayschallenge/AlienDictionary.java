package thirtydayschallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        Set<Character>[] graph = new HashSet[26];
        int[] status = new int[26];

        for(String word : words) {
            for(char c : word.toCharArray()) {
                if(graph[c - 'a'] == null)
                    graph[c - 'a'] = new HashSet<>();
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int j = 0;
            for(; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2) {
                    graph[c1 - 'a'].add(c2);
                    break;
                }
            }
            if(j == Math.min(word1.length(), word2.length()) && word1.length() > word2.length()) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= 25; i++) {
            char c = (char) (i + 'a');
            if(graph[i] != null && status[i] == 0) {
                boolean canComplete = dfs(c,graph , status, sb) ;
                if(!canComplete)
                    return "";
            }
        }

        return sb.reverse().toString();
    }

    private boolean dfs(char c, Set<Character>[] graph, int[] status, StringBuilder sb) {
        if(status[c - 'a'] == 1) {
            return false;
        }

        if(status[c - 'a'] == 2) {
            return true;
        }

        status[c - 'a'] = 1;

        boolean res = true;
        for(char child : graph[c - 'a']) {
            boolean temp = dfs(child, graph, status, sb);
            res = res && temp;
        }

        status[c - 'a'] = 2;
        sb.append(c);
        return res;
    }
}
