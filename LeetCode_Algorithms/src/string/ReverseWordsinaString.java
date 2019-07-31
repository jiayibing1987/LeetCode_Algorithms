package string;

import java.util.Arrays;
import java.util.Collections;

/**
 * 151. Reverse Words in a String
 * 
 * Given an input string, reverse the string word by word.
 * @author Ryan
 *
 */
public class ReverseWordsinaString {

    public String reverseWords(String s) {
        String[] array = s.trim().split(" +");
        Collections.reverse(Arrays.asList(array));
        return String.join(" ", array); //add delimiter to each element
    }
    
	public static void main(String[] args) {
		ReverseWordsinaString r = new ReverseWordsinaString();
		System.out.println(r.reverseWords("  hello world!  "));
	}

}
