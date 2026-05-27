package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. Reverse Words in a String
 * 
 * Given an input string, reverse the string word by word.
 * @author Ryan
 *
 */
public class ReverseWordsinaString {

    /*public String reverseWords(String s) {
        String[] array = s.trim().split(" +");
        Collections.reverse(Arrays.asList(array));
        return String.join(" ", array); //add delimiter to each element
    } */

    public String reverseWords(String s) {
        s = s.trim();
        int left = 0;
        List<String> subs = new ArrayList<>();
        for(int right = 0; right < s.length(); right ++) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);

            if(c1 != ' ' && (c2 == ' ' || right == s.length() - 1)) {
                subs.add(s.substring(left, (right == s.length() - 1) ? right + 1 : right));
                left = right + 1;
            } else if (c1 == ' ' && c2 == ' ') {
                left ++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = subs.size() - 1; i >= 0; i --) {
            String sub = subs.get(i);
            sb.append(sub);
            if(i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		ReverseWordsinaString r = new ReverseWordsinaString();
		//System.out.println(r.reverseWords("the sky is blue"));
        System.out.println(r.reverseWords("t "));
	}

}
