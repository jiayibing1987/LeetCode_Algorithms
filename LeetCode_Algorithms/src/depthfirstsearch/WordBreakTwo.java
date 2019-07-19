package depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 140. Word Break II
 * @author Ryan
 *
 */
public class WordBreakTwo {

	public List<String> wordBreak(String s, List<String> wordDict) {
		return helper(new HashSet<String>(wordDict), s, new HashMap<String, List<String>>());
	}

	private List<String> helper(Set<String> wordDict, String remain, HashMap<String, List<String>> map) {
		if (map.containsKey(remain)) {
			return map.get(remain);
		}
		List<String> result = new ArrayList<String>();
		if (remain.isEmpty()) {
			return result;
		}
		for (int i = 1; i <= remain.length(); i++) {
			String temp = remain.substring(0, i);
			if (wordDict.contains(temp)) {	
				String newRemain = remain.substring(i);
				List<String> subList = helper(wordDict, newRemain, map);
				//remaining is not a word dont't add to result list but search for next possible
				if(subList.isEmpty() && newRemain.isEmpty()==false){
					continue;
				}
				if (subList.isEmpty())
					result.add(temp);
				else {
					for (String subString : subList) {
						result.add(temp + " " + subString);
					}
				}
			}
		}
		map.put(remain, result);
		return result;
	}

	public static void main(String[] args) {
		WordBreakTwo w = new WordBreakTwo();
		String[] words = { "cat", "cats", "and", "sand", "dog" };
		List<String> l = Arrays.asList(words);
		//System.out.print(w.wordBreak("catsanddog", l));
		
		String[] words1 = {"aaaa", "aaa"};
		List<String> l1 = Arrays.asList(words1);
		System.out.print(w.wordBreak("aaaaaaa", l1));


		
	}

}
