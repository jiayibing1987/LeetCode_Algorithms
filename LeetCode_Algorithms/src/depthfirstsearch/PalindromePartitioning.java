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
		backTrack(results, new ArrayList<String>(), s);
		return results;
	}

	//     aab
	// a 	aa 	aab
	//a ab  b
	//b
	private void backTrack(List<List<String>> results, List<String> temp, String s) {
		if (s.isEmpty()) {
			results.add(new ArrayList<String>(temp));
		} else {
			for (int i = 1; i <= s.length(); i++) {
				if (!isPalindrome(s, i))
					continue;
				String firstPart = s.substring(0, i);
				String remains = i == s.length() ? "" : s.substring(i);
				temp.add(firstPart);
				backTrack(results, temp, remains);
				temp.remove(temp.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int i) {
		int low = 0;
		int high = i - 1;
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
