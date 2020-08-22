package binarysearch;

import java.util.*;

public class LongestDuplicateSubstring {

    public String longestDupSubstring(String S) {
        int start = 0;
        int len = 0;
        int low = 1;
        int high = S.length()-2;
        //binary search to find a length that
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(mid < 1) break;
            //check if we can find a sub-string with length mid
            Map.Entry<Integer, Integer> pair = findDuplicateSubstringWithLength (S, mid);
            if(pair == null) {
                high = mid-1;
            }else {
                low = mid + 1;
                start = pair.getKey();
                len = pair.getValue();
            }
        }

        return S.substring(start, start+len) ;
    }

    private Map.Entry<Integer, Integer> findDuplicateSubstringWithLength(String s, int k) {
        String res;
        Map<Integer, List<Integer>> map = new HashMap<>();

        String cur_subString = s.substring(0, k);
        StringBuilder sb = new StringBuilder(cur_subString);
        int hashCode = cur_subString.hashCode();
        map.put(hashCode, new ArrayList<Integer>());
        map.get(hashCode).add(0);

        for(int i=1; i<=s.length()-k ; i++) {
            sb = sb.deleteCharAt(0);
            sb = sb.append(s.charAt(i+k-1));
            cur_subString = sb.toString();
            hashCode = cur_subString.hashCode();
            if(map.containsKey(hashCode)) {
                for(int j : map.get(hashCode)) {
                    if(compare(i, j, k, s))
                        return new AbstractMap.SimpleEntry<Integer, Integer>(i, k);
                }
            }else {
                map.put(hashCode, new ArrayList<Integer>());
            }
            map.get(hashCode).add(i);
        }
        return null;
    }

    private boolean compare(int i, int j, int len, String s) {
        for(int index = 0; index < len; index++) {
            if(s.charAt(i+index) != s.charAt(j+index))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestDuplicateSubstring().longestDupSubstring("banana"));
    }
}
