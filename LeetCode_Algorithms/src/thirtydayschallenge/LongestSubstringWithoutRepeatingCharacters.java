package thirtydayschallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int max = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        Set<Character> set= new HashSet<>();

        int left = 0;
        //int right = 0;

//        while(left < n && right < n) {
//            if(set.contains(chars[right])) {
//                set.remove(chars[left]);
//                left ++;
//            }else {
//                set.add(chars[right]);
//                max = Math.max(right- left + 1, max);
//                right ++;
//            }
//        }
        for(int right = 0; right < s.length(); right ++) {
            char c = chars[right];
            if(set.contains(c)) {
                while(chars[left] != c && left < right) {
                    set.remove(chars[left] );
                    left++;
                }
                left++;
            } else {
                set.add(c);
                max = Math.max(max, right - left + 1);
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
