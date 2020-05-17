package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 */
public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>(); //occurrence of character
        List<Integer> res = new ArrayList<>();
        if(s == null || s.isEmpty() || s.length() < p.length()) return res;
        for(char c : p.toCharArray()) //init map with p
            map.put(c, map.getOrDefault(c, 0) - 1);

        int start = 0, end = 0, count = 0; // count is number of entry with value 0
        for(; end < p.length(); end++) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if(map.get(c) == 0) count ++;
                if(map.get(c) == 1) count --;
            }
        }
        if(count == map.size()) res.add(0);

        for(; end < s.length(); end++) {
            char c = s.charAt(start);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) count ++;
                if(map.get(c) == -1) count --;
            }
            start++;

            c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if(map.get(c) == 0) count ++;
                if(map.get(c) == 1) count --;
            }

            if(count == map.size()) res.add(start);
        }
        return res;
    }

}
