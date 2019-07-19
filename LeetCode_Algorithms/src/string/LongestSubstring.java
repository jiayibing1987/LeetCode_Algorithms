package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * @author Ryan
 *
 */
public class LongestSubstring {

//	public int lengthOfLongestSubstring(String s) {
//		Set<Character> set = new HashSet<Character>();
//		char[] array = s.toCharArray();
//		int max = 0;
//		for (int i = 0; i < array.length; i++) {
//			set.clear();
//			for (int j = i; j < array.length; j++) {
//				if (!set.contains(array[j])) {
//					set.add(array[j]);
//				}else{
//					break;
//				}
//			}
//			max = Math.max(max, set.size());
//		}
//		return max;
//	}
	
	
	public int lengthOfLongestSubstring(String s) {
		char[] array = s.toCharArray();
		int max = 0;
		int start = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			if(map.containsKey(array[i]) && map.get(array[i])>=start){
				start = map.get(array[i])+1;
			}
			map.put(array[i], i);
			int length = i-start+1;
			max = Math.max(max, length);
		}
		return max;
	}
	

	public static void main(String[] args) {
		LongestSubstring l = new  LongestSubstring();
		System.out.println(l.lengthOfLongestSubstring("abba"));
		System.out.println(l.lengthOfLongestSubstring("bbbbb"));
		System.out.println(l.lengthOfLongestSubstring("pwwkew"));
		System.out.println(l.lengthOfLongestSubstring(" "));

	}

}
