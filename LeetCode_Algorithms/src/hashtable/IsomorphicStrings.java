package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * @author Ryan
 *
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
    	if(s == null || t == null) return false;
    	if(s.length() != t.length()) return false;
    	Map<Character, Integer> mapS = new HashMap<Character, Integer>();
    	Map<Character, Integer> mapT = new HashMap<Character, Integer>();

    	for(int i=0; i<s.length(); i++){
    		int indexS = mapS.getOrDefault(s.charAt(i), -1);
    		int indexT = mapT.getOrDefault(t.charAt(i), -1);
    		if(indexS != indexT) return false;
    		mapS.put(s.charAt(i), i);
    		mapT.put(t.charAt(i), i);
    	}
    	return true;
    }

    public boolean isIsomorphic1(String s, String t) {
    	if(s == null || t == null) return false;
    	if(s.length() != t.length()) return false;
    	Map<Character, List<Integer>> mapS = this.getMap(s);
    	Map<Character, List<Integer>> mapT = this.getMap(t);
        for(Map.Entry<Character, List<Integer>> entry: mapS.entrySet()){
        		int index = entry.getValue().get(0);
        		char c = t.charAt(index);
        		if(mapT.get(c).size() != entry.getValue().size()) 
        			return false;
        		if(mapT.get(c).size() > 1 && !mapT.get(c).equals(entry.getValue()))
        			return false;
        }
        return true;
    }
    
    
    private Map<Character, List<Integer>>  getMap(String s){
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        for(int i=0; i<s.length(); i++){
        	Character c = s.charAt(i);
        	if(map.containsKey(c)){
        		map.get(c).add(i);
        	}else{
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		map.put(c, list);
        	}
        }
        return map;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
