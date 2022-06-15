package thirtydayschallenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, new LengthComparator());
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        int max = 1;

        for(int i = 1; i < n; i ++) {
            String curWord = words[i];
            map.put(curWord, 1);
            for(int j = 0; j < curWord.length(); j ++) {
                String temp = new StringBuilder(curWord).deleteCharAt(j).toString();
                if(map.containsKey(temp)) {
                    map.put(curWord, Math.max(map.get(curWord), map.get(temp) + 1));
                }
            }
            max = Math.max(max, map.get(curWord));
        }
        return max;
    }

    static class LengthComparator implements Comparator<String> {

        public int compare (String s1, String s2) {
            return s1.length() - s2.length();
        }
    }
}
