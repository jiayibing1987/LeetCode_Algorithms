package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;


/**
 * #131
 * Given a string s, partition s such that every substring of the partition is a palindrome.
	Return all possible palindrome partitioning of s.
 * @author Ryan
 *
 */
public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> results = new ArrayList<List<String>>();
		if(s== null || s.isEmpty()) return results;
		backTrack(results, new ArrayList<String>(), s);
		return results;
	}

	private void backTrack(List<List<String>> results, List<String> temp, String s){
		if(s.isEmpty()){
			results.add(temp);
			return;
		}
		for(int i=1; i<=s.length(); i++){
			String prefix = s.substring(0,i);
			if(!isPalindrome(prefix)) continue;
			String remain = i==s.length()? "" : s.substring(i,s.length());
			List<String> list = new ArrayList<String>(temp);
			list.add(prefix);
			backTrack(results, list, remain);
		}
	}

	private boolean isPalindrome(String s) {
		int low = 0;
		int high = s.length() - 1;
		while (low < high) {
			if (s.charAt(low) != s.charAt(high))
				return false;
			low++;
			high--;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioning p = new PalindromePartitioning();
		String a = "aab";
		System.out.println(p.partition(a));
	}

}
