package thirtydayschallenge;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, res, new ArrayList<>());
        return res;
    }

    private void dfs(String remain, List<List<String>> res, List<String> temp) {
        if(remain.length() == 0) {
            res.add(temp);
            return;
        }
        int n = remain.length();
        for(int i = 1; i <= n; i++) {
            String cur = remain.substring(0, i);
            if(!isPalindrome(cur))
                continue;
            String left = i == n ? "" : remain.substring(i);
            List<String> copy = new ArrayList<>(temp);
            copy.add(cur);
            dfs(left, res, copy);
        }
    }

    private boolean isPalindrome (String s) {
        if(s == null || s.length() == 0) return false;
        int l = 0;
        int r = s.length() - 1;

        while(l < r) {
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        System.out.println(p.partition("aab"));
    }
}
