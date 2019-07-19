package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * @author Ryan
 *
 */
public class LetterCombinations {

    Map<Character, String> map = new HashMap<Character, String>();
    public List<String> letterCombinations(String digits) {
        initMap(map);
        List<String> results = new ArrayList<String>();
        if(digits == null || digits.isEmpty())
        	return results;
        backTrack(results, "", 0, digits);
        return results;
    }
    
    private void backTrack(List<String> results, String temp, int index, String digits){
    	if(index >= digits.length()){
    		results.add(temp);
    		return;
    	}
    	String letters = map.get(digits.charAt(index));
    	for(int i=0; i<letters.length(); i++){
    		backTrack(results, temp + String.valueOf(letters.charAt(i)), index+1, digits);
    	}
    }
    
    private void initMap( Map<Character, String> map){
    	   map.put('2', "abc");
           map.put('3', "def");
           map.put('4', "ghi");
           map.put('5', "jkl");
           map.put('6', "mno");
           map.put('7', "pqrs");
           map.put('8', "tuv");
           map.put('9', "wxyz");
    }
    
	public static void main(String[] args) {
		LetterCombinations l = new LetterCombinations();
		System.out.println(l.letterCombinations("23"));
	}

}
