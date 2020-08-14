package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        int odd = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int frequency : map.values()) {
            if(frequency % 2 == 0)
                count += frequency;
            else {
                count += frequency - 1;
                odd ++;
            }
        }
        return odd >0 ? count + 1 : count;
    }

}
