package twopointer;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        for(int p2 = 0; p2<t.length(); p2++) {
            if(p1 == s.length()) return true;
            if(s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
        }
        return p1 == s.length();
    }

}
