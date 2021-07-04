package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountVowelsPermutation {

    long m = 1000000000 + 7;
    Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
    Map<String, Long> map = new HashMap<>();
    public int countVowelPermutation(int n) {
        long res = helper(' ', n);
        return (int)(res % m);
    }

    private long helper(char c, int n) {
        if(n == 0)
            return 1;

        String key = c + " " + n;
        if(map.containsKey(key))
            return map.get(key);

        long ans = 0;
        if(c == 'a') {
            ans = helper('e', n -1) % m;
        } else if (c == 'e') {
            ans = helper('a', n-1) % m + helper('i', n - 1) % m;
        } else if (c == 'i') {
            for(char v : set) {
                if(v == 'i') continue;
                ans += helper(v, n - 1) % m;
            }
        } else if (c == 'o') {
            ans = helper('i', n - 1) % m + helper('u', n - 1) % m;
        } else if (c == 'u') {
            ans = helper('a', n -1) % m;
        } else {
            for(char v : set) {
                ans += helper(v, n - 1) % m;
            }
        }
        map.put(key, ans);
        return ans;
    }
}
