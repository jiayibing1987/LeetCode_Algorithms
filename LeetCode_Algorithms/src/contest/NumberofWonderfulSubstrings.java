package contest;

import java.util.HashSet;
import java.util.Set;

public class NumberofWonderfulSubstrings {

    public long wonderfulSubstrings1(String word) {
        int n = word.length();
        long count = 0;

        Set[][] memo = new Set[n][n];

        for (int j = 0; j < n; j++) {
            char c = word.charAt(j);
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    Set<Character> set = new HashSet<>();
                    set.add(word.charAt(i));
                    memo[i][j] = set;
                    count++;
                } else {
                    Set<Character> set = memo[i][j - 1];
                    Set<Character> newSet = new HashSet<>(set);
                    if (newSet.contains(c)) {
                        newSet.remove(c);
                    } else {
                        newSet.add(c);
                    }
                    count += newSet.size() <= 1 ? 1 : 0;
                    memo[i][j] = newSet;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberofWonderfulSubstrings w = new NumberofWonderfulSubstrings();
        System.out.println(w.wonderfulSubstrings1("aba"));
        System.out.println(w.wonderfulSubstrings1("aabb"));
    }
}
