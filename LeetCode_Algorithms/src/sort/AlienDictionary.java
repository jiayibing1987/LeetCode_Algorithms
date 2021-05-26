package sort;

import org.apache.commons.collections.map.HashedMap;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> status = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                status.putIfAbsent(c, 0);
            }
        }

        //compare Adjacent words in words list, get edges info
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int len1 = word1.length();
            int len2 = word2.length();

            int j = 0;
            for (; j < Math.min(len1, len2); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
            if (len1 > len2 && j == len2) return ""; //word1 start with word2
        }

        StringBuilder sb = new StringBuilder();
        for (char c : graph.keySet()) {
            if (status.get(c) == 0) {
                boolean canComplete = dfs(c, graph, status, sb);
                if (!canComplete) {
                    return "";
                }
            }
        }

        return sb.reverse().toString();
    }

    //topological sort dfs
    private boolean dfs(char c, Map<Character, Set<Character>> graph, Map<Character, Integer> status, StringBuilder sb) {
        if (status.get(c) == 2) {
            return true;
        }

        if (status.get(c) == 1) {
            return false;
        }

        status.put(c, 1);
        for (char child : graph.get(c)) {
            boolean canComplete = dfs(child, graph, status, sb);
            if (!canComplete) return false;
        }
        status.put(c, 2);
        sb.append(c);
        return true;
    }

    public static void main(String[] args) {
        String[] w1 = {"wrt", "wrf", "er", "ett", "rftt"};
        AlienDictionary a = new AlienDictionary();
        System.out.println(a.alienOrder(w1));
    }
}
