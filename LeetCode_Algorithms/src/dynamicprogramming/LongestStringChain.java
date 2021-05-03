package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;

        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >=0; j--) {
                if(isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //System.out.println(words[i] + " " + i + " isPredecessor of " + words[j] + " " + j + " dp is " + dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    private boolean isPredecessor(String word1, String word2) {
        if(word1.length() + 1 != word2.length())
            return false;

        int diff_count = 0;
        int same_count = 0;
        int i = 0, j = 0;
        while(i<word1.length() && j < word2.length()) {
            if(word1.charAt(i) != word2.charAt(j)) {
                j++;
                diff_count ++;
            } else {
                i++; j++;
                same_count ++;
            }
            if(diff_count == 2) return false;
        }
        return same_count > 0;
    }

    public static void main(String[] args) {
        LongestStringChain l = new LongestStringChain();
        String[] words = new String[] {"qyssedya","pabouk","mjwdrbqwp","vylodpmwp","nfyqeowa","pu","paboukc","qssedya",
                "lopmw","nfyqowa","vlodpmw","mwdrqwp","opmw","qsda","neo","qyssedhyac","pmw","lodpmw","mjwdrqwp","eo",
                "nfqwa","pabuk","nfyqwa","qssdya","qsdya","qyssedhya","pabu","nqwa","pabqoukc","pbu","mw","vlodpmwp","x","xr"};
        System.out.println(l.longestStrChain(words));
    }
}
