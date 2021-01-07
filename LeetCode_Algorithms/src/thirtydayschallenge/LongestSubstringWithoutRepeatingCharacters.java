package thirtydayschallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int max = 0;
        char[] chars = s.toCharArray();
        Set<Character> set= new HashSet<>();

        int left = 0;
        int len = 0;

        for(int right = 0; right < s.length(); right ++) {
            char c = chars[right];
            len++;
            if(set.contains(c)) {
                while(chars[left] != c && left < right) {
                    set.remove(chars[left] );
                    len--;
                    left++;
                }
                len--;
                left++;
            } else {
                set.add(c);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("aab"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }
}
