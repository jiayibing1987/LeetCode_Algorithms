package hashtable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for(int i = 0; i<s.length(); i++) {
            char c = chars[i];
            if(map.containsKey(c))
                map.put(c, s.length());
            else
                map.put(c, i);
        }

        int index = s.length();
        for(Map.Entry<Character, Integer> entry : map.entrySet() ) {
            index = Math.min(entry.getValue(), index );
        }

        return index == s.length() ? -1 : index;
    }

}
