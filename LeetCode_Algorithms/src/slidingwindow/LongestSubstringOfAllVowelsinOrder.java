package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringOfAllVowelsinOrder {

    public int longestBeautifulSubstring(String word) {
        Set<Character> set = new HashSet<>();
        int n = word.length();
        int max = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (word.charAt(r) == 'a' && (r== 0 || word.charAt(r - 1) != 'a')) {
                l = r;
                set.clear();
                set.add('a');
            } else {
                if (r >0 && word.charAt(r) >= word.charAt(r - 1)) {
                    set.add(word.charAt(r));
                    if (set.size() == 5) {
                        max = Math.max(max, r - l + 1);
                    }
                } else {
                    set.clear();
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringOfAllVowelsinOrder l = new LongestSubstringOfAllVowelsinOrder();
        System.out.println(l.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        //System.out.println(f.maxFrequency(new int[]{1,4,8,13}, 5));
        //System.out.println(f.maxFrequency(new int[]{10000}, 10000));
    }
}
