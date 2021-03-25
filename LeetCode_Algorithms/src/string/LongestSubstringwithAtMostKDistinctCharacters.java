package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0; int r = 0;
        int n = s.length();

        int max = 0;
        for(; r < n; r ++){
            char rightChar = s.charAt(r);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            if(map.size() <=k) {
                max = Math.max(max, (r - l + 1));
            } else {
                //remove left pointer character and update map
                while(map.size() > k && l < r) {
                    char leftChar = s.charAt(l);
                    map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                    if(map.get(leftChar) <= 0) map.remove(leftChar);
                    l++;
                }
            }
        }
        return max;
    }

    public static void main (String[] args) {
        LongestSubstringwithAtMostKDistinctCharacters l = new LongestSubstringwithAtMostKDistinctCharacters();
        System.out.println(l.lengthOfLongestSubstringKDistinct("aba", 1));
    }

}
