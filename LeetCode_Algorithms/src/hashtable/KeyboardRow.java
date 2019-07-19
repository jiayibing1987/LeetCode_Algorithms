package hashtable;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * # 500
 * Given a List of words, return the words that can be typed using letters of alphabet 
 * on only one row's of American keyboard like the image below.
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 */
public class KeyboardRow {

    public String[] findWords(String[] words) {
        List<String> results = new ArrayList<String>();
        String firstString = "QWERTYUIOP";
        String secondString = "ASDFGHJKL";
        String thirdString = "ZXCVBNM";
    	Set<Character> firstRow = new HashSet<Character> ();
    	Set<Character> secondRow = new HashSet<Character> ();
    	Set<Character> thirdRow = new HashSet<Character> ();
    
    	for(Character c : firstString.toCharArray()){
    		firstRow.add(c);
    	}
    	for(Character c : secondString.toCharArray()){
    		secondRow.add(c);
    	}
    	for(Character c : thirdString.toCharArray()){
    		thirdRow.add(c);
    	}
    	
    	for(String word : words){
    		Set<Character> wordSet = new HashSet<Character> ();
        	for(Character c : word.toUpperCase().toCharArray()){
        		wordSet.add(c);
        	}
    		if(firstRow.containsAll(wordSet) || secondRow.containsAll(wordSet) || thirdRow.containsAll(wordSet))
    			results.add(word);
    	}
    	
    	return results.toArray(new String[0]);
    }
	
	
	public static void main(String[] args) {
		KeyboardRow keyboardRow = new KeyboardRow();
		String[] inputs = new String[]{"Hello", "Alaska", "Dad", "Peace"};
		for(String output : keyboardRow.findWords(inputs))
			System.out.println(output);
	}

}
