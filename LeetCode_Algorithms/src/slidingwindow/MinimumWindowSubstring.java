package slidingwindow;

import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";

        //init table for string t
        Map<Character, Integer> mapT = new HashMap<>();
        for(char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        //count for unique chars in string t
        int target_count = mapT.size();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0; int right = 0; int count = 0;
        int minLeft = -1; int minRight = s.length();

        for( ; right < s.length(); right ++) {
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            if(mapT.containsKey(rightChar) && window.get(rightChar).intValue() == mapT.get(rightChar).intValue()) {
                count ++;
            }

            //move left pointer until windows does not contain all characters in string t
            while(count == target_count && left <= right) {
                if(right - left < minRight - minLeft) {
                    minLeft = left;
                    minRight = right;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if(mapT.containsKey(leftChar) && window.get(leftChar) == mapT.get(leftChar) - 1) {
                    count --;
                }

                left ++;
            }
        }

        return minLeft == -1 ? "" : s.substring(minLeft, minRight + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(m.minWindow("a", "a"));
    }
}
