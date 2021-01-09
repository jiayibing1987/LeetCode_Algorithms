package thirtydayschallenge;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();

        q1.add(beginWord);
        q2.add(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);
        int depth1 = 1;
        int depth2 = 1;

        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (pathExistsHelper(q1, visited1, visited2, wordList))
                return depth1 + depth2;
            depth1++;

            if (pathExistsHelper(q2, visited2, visited1, wordList))
                return depth1 + depth2;
            depth2++;
        }
        return 0;
    }

    private boolean pathExistsHelper(Queue<String> q, Set<String> visitedSameDirection,
                                     Set<String> visitedOppositeDirection, List<String> wordList) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            String parentWord = q.poll();
            for (String candidate : wordList) {
                if (visitedSameDirection.contains(candidate)) continue;
                if (countDifferences(candidate, parentWord) == 1) {
                    if (visitedOppositeDirection.contains(candidate))
                        return true;
                    q.add(candidate);
                    visitedSameDirection.add(candidate);
                }
            }
        }
        return false;
    }

    private int countDifferences(String w1, String w2) {
        if (w1.isEmpty()) return 0;
        int n = w1.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (w1.charAt(i) != w2.charAt(i))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        List<String> l1 = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(w.ladderLength("hit", "cog", l1));
    }
}
