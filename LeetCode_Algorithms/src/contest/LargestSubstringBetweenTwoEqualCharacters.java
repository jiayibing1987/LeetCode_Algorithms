package contest;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        //map to store the right most index of a character
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(chars[i], i);
        }

        int max = -1;
        for(int i=0; i<n; i++) {
            char c = chars[i];
            if(map.containsKey(c)) {
                max = Math.max(max, map.get(c) - i - 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestSubstringBetweenTwoEqualCharacters l = new LargestSubstringBetweenTwoEqualCharacters();
        int res1 = l.maxLengthBetweenEqualCharacters("aa");
        System.out.println(res1);
        int res2 = l.maxLengthBetweenEqualCharacters("cabbac");
        System.out.println(res2);

    }

}
