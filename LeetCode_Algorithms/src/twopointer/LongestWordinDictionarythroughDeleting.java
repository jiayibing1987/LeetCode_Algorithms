package twopointer;

import java.util.Arrays;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        String maxWord = "";
        for(String word : d) {
            if(isSubsequence(s, word) && (word.length() > maxWord.length()
                    || (word.length() == maxWord.length() && word.compareTo(maxWord) < 0))) {
                    maxWord = word;
            }
        }

        return maxWord;
    }

    private boolean isSubsequence (String s, String word) {
        int j = 0;
        for(int i = 0; i<s.length(); i++) {
            if(j == word.length()) return true;
            if(s.charAt(i) == word.charAt(j)) {
                j++;
            }
        }
        return j == word.length();
    }

    public static void main(String[] args) {
        LongestWordinDictionarythroughDeleting l = new LongestWordinDictionarythroughDeleting();
        String[] dic = new String[] {"ale","apple","monkey","plea"};
        System.out.println(l.findLongestWord("abpcplea", Arrays.asList(dic)));
    }

}
