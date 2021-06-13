package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberofRemovableCharacters {

    public int maximumRemovals(String s, String p, int[] removable) {
        int low = 0;
        int high = removable.length;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            boolean isSubseq = isSubsequence(s, p, removable, mid);
            if(isSubseq) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public boolean isSubsequence(String s, String p, int[] removable, int k) {
        Set<Integer> removed = new HashSet<>();
        for(int i = 0; i < k; i ++) {
            removed.add(removable[i]);
        }

        int p1 = 0; int p2 = 0;
        for(; p1 < s.length() && p2 < p.length(); p1 ++) {
            if(removed.contains(p1)) continue;
            if(s.charAt(p1) == p.charAt(p2)) {
                p2 ++;
            }
        }
        return p2 == p.length();
    }

    public static void main(String[] args) {
        MaximumNumberofRemovableCharacters m = new MaximumNumberofRemovableCharacters();
        int[] r1 = new int[] {3, 1, 0};
        System.out.println(m.maximumRemovals("abcacb", "ab", r1));
    }
}
