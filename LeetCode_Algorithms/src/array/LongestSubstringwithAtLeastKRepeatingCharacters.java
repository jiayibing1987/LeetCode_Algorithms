package array;

import java.util.*;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        return helper(s, k, 0, s.length()-1);
    }

    private int helper(String s, int k, int low, int high) {
        if(high - low + 1 < k) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i= low; i<=high; i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);


        Set<Character> set = new HashSet<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() < k)
                set.add(entry.getKey());
        }
        if(set.isEmpty()) return high - low + 1;

        List<Integer> list = new ArrayList<>();
        for(int i=low; i<=high; i++) {
            if(set.contains(s.charAt(i)))
                list.add(i);
        }
        list.add(high+1);

        int max = 0;
        int pre = -1;
        for(int cur : list) {
            max = Math.max(helper(s, k, pre+1, cur-1), max);
            pre = cur;
        }
        return max;
    }

    public static void main (String[] args) {
        LongestSubstringwithAtLeastKRepeatingCharacters l = new LongestSubstringwithAtLeastKRepeatingCharacters();
        System.out.println(l.longestSubstring("aaabb", 3));
    }
}
