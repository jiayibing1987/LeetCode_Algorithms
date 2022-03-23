package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPalindromeUsingSameDigits {

    public String nextPalindrome(String num) {
        int n = num.length();
        if(n <= 2) return "";
        char[] chars = num.toCharArray();
        int m = (n -1) / 2;
        if(n % 2 == 1)
            m --;

        int first = -1;
        for(int i = m; i -1 >= 0; i --) {
            if(chars[i] > chars[i - 1]) {
                first = i - 1;
                break;
            }
        }
        if(first == -1)
            return "";

        int second = first + 1;
        char min = chars[first + 1];
        for(int i = first + 1; i <= m; i++) {
            if(chars[i] > chars[first] && chars[i] < min){
                second = i;
                min = chars[i];
            }
        }

        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;

        List<Character> afterPart = new ArrayList<>();
        for(int i = first + 1; i <= m; i ++) {
            afterPart.add(chars[i]);
        }
        Collections.sort(afterPart);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= first; i ++) {
            sb.append(chars[i]);
        }
        for(int i = 0; i < afterPart.size(); i ++) {
            sb.append(afterPart.get(i));
        }

        if(n % 2 != 0)
            return sb.toString() + chars[m + 1] + sb.reverse();
        return sb.toString() + sb.reverse();
    }

    public static void main(String[] args) {
        NextPalindromeUsingSameDigits p = new NextPalindromeUsingSameDigits();
        System.out.println(p.nextPalindrome("23143034132"));
    }
}
