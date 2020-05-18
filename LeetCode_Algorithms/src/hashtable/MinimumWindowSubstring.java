package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length())
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) - 1);

        int start = 0, end = 0, count = 0;//count the map which value >= 0,
                                        // means in current sub-string  there are enough characters for string t
        int minStart = start, minEnd = end, minLength = Integer.MAX_VALUE;
        while(end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if (map.get(c) == 0) count++;
            }

            while (count == map.size()) {
                if(end - start < minLength) { //record end and start
                    minStart = start;
                    minEnd = end;
                    minLength = end - start;
                }

                c = s.charAt(start);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == -1) count --;
                }

                start++;
            }

            end++;
        }
        if(minLength == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minEnd + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String s1 = "aaxxxxxbbcxxxbca";
        String t1 = "abc";
        System.out.println(new MinimumWindowSubstring().minWindow(s1, t1));
    }
}