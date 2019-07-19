package string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * #387
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * @author Ryan
 *
 */
public class FindUniqueCharacter {

    public int firstUniqChar(String s) {
    	Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
    	for(char c : s.toCharArray()){
    		if(!map.containsKey(c)){
    			map.put(c, 1);
    		}else{
    			int n = map.get(c);
    			map.put(c, n+1);
    		}
    	}
    	
    	String c = null;
    	for(Map.Entry<Character, Integer> entry: map.entrySet()){
    		if(entry.getValue() == 1){
    			c = entry.getKey().toString();
    			break;
    		}
    	}
    	return c == null? -1 : s.indexOf(c);
    }
	
	public static void main(String[] args) {
		FindUniqueCharacter f = new FindUniqueCharacter();
		System.out.println(f.firstUniqChar("leetcode"));
		System.out.println(f.firstUniqChar("loveleetcode"));
		System.out.println(f.firstUniqChar("dddccdbba"));

	}

}
