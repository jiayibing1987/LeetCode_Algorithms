package twopointer;

public class IsSubsequence {

    /*public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        for(int p2 = 0; p2<t.length(); p2++) {
            if(p1 == s.length()) return true;
            if(s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
        }
        return p1 == s.length();
    } */

    public boolean isSubsequence(String s, String t) {
        int p1 = 0; int p2 = 0;
        while(p1 < s.length() && p2 < t.length()) {
            char c1 = s.charAt(p1);
            char c2 = s.charAt(p2);
            if(c1 == c2) {
                p1 ++;
                p2 ++;
            } else {
                p2++;
            }
        }
        return p1 >= s.length();
    }
}
