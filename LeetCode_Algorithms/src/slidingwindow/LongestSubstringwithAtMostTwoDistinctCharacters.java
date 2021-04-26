package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0;
        //ccaabbb
        for(int r = 0; r < s.length(); r ++) {
            char rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            if(map.keySet().size() <=2 ) {
                max = Math.max(max, r - l + 1);
            } else {
                do {
                    char lc = s.charAt(l);
                    map.put(lc, map.get(lc) - 1);
                    if(map.get(lc) == 0) map.remove(lc);
                    l++;
                }while(map.keySet().size() > 2);
            }
        }
        return max;
    }

}
