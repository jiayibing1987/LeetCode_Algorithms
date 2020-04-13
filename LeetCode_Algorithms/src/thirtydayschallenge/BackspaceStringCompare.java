package thirtydayschallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare1(String S, String T) {
        String s1 = helper1(S);
        String s2 = helper1(T);
        return s1.equals(s2);
    }

    private String helper1(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : chars) {
            if(c == '#' && !stack.isEmpty())
                stack.pop();
            else if(c != '#')
                stack.push(c);
        }
        return String.valueOf(stack);
    }

    public boolean backspaceCompare(String S, String T) {
        int p1 = 0, p2 = 0;
        char[] c1 = helper(S);
        char[] c2 = helper(T);
        while(p1 < S.length() && p2 < T.length()) {
            while(p1 < S.length() && c1[p1] == '#')
                p1++;
            while(p2 < T.length() && c2[p2] == '#')
                p2++;
            if(p1 == S.length() || p2 == T.length())
                break;
            if(c1[p1] != c2[p2])
                return false;
            p1++;
            p2++;
        }
        if(p1 == S.length()){
            while(p2 < T.length()) {
                if (c2[p2] != '#') return false;
            }
        }
        if(p2 == T.length()){
            while(p1 < S.length()) {
                if (c1[p1] != '#') return false;
            }
        }
        return true;
    }

    private char[] helper(String s){
        char[] chars = s.toCharArray();
        int count = 0;
        for(int i=s.length()-1; i>=0; i--) {
            if(chars[i] == '#')
                count++;
            else if (chars[i]!='#' && count>0){
                chars[i] = '#';
                count --;
            }
        }
        return chars;
    }

    public static void main (String[] args) {
        String s1 = "ab##";
        String s2 = "cd##";
        System.out.println(new BackspaceStringCompare().backspaceCompare(s1, s2));
    }
}
