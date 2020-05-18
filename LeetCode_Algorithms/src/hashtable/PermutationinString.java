package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 */
public class PermutationinString {

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) - 1);

        int start = 0,  end = 0,  count = 0;
        for(; end < s1.length(); end++) {
            char c = s2.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) <= 0)
                    count++;
                else
                    count--;
            }
        }
        if(count == s1.length()) return true;

        for(; end < s2.length(); end++) {
            char c = s2.charAt(start);
            if(map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c)>= 0)
                    count++;
                else
                    count --;
            }
            start++;

            c = s2.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) <= 0)
                    count++;
                else
                    count--;
            }
            if(count == s1.length()) return true;
        }

        return false;
    }

}
