package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	for(String s: strs){
    		String sortedString = sortString(s);
    		if(!map.containsKey(sortedString)){
    			List<String> l = new ArrayList<String>();
    			l.add(s);
    			map.put(sortedString, l);
    		}else{
    			map.get(sortedString).add(s);
    		}
    	}
    	return new ArrayList<List<String>>(map.values());
    }
    
    private String sortString(String s){
    	char[] charArray = s.toCharArray();
    	Arrays.sort(charArray);
    	return new String(charArray);
    }
    
	public static void main(String[] args) {
		GroupAnagrams g = new GroupAnagrams();
		String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(g.groupAnagrams(a));
	}

}
