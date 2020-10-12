package greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() <= 1) return s;

        char[] charArray = s.toCharArray();
        char[] res = new char[s.length()];

        int[] charIndex = new int[26];
        Arrays.fill(charIndex, -1);

        for(int i = 0; i< charArray.length; i++) {
            char c = charArray[i];
            //check if char already exists in result array
            if(charIndex[c-'a'] != -1) {
                int preIndex = charIndex[c-'a'];
                //find the next char after preIndex
                char nextShiftChar = findNextChar(res, preIndex, i);
                if(nextShiftChar >= c)
                    res[i] = '#';
                else{
                    res[preIndex] = '#';
                    charIndex[c-'a'] = i;
                }
            }else {
                res[i] = c;
                charIndex[c-'a'] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : res) {
            if(c != '#')
                sb.append(c);
        }
        return sb.toString();
    }

    private char findNextChar (char[] a, int start, int end) {
        for(int i=start+1; i<end; i++){
            if(a[i] != '#')
                return a[i];
        }
        return a[start];
    }

    public static void main (String[] args) {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        System.out.print(r.removeDuplicateLetters("bcabc"));
    }
}
