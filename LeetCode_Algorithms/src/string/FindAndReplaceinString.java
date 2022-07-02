package string;

import java.util.*;

public class FindAndReplaceinString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = indices.length;
        int n = s.length();

        Map<Integer, String[]> map = new HashMap<>();
        for(int i = 0; i < k; i ++) {
            int start= indices[i];
            int end = start + sources[i].length();
            String orginal = s.substring(start, Math.min(end, n));
            if(orginal.equals(sources[i])) {
                map.put(start, new String[] {sources[i], targets[i]});
            }
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < n) {
            if(map.containsKey(index)) {
                String[] arr = map.get(index);
                sb.append(arr[1]);
                index += arr[0].length();
            } else {
                sb.append(s.charAt(index));
                index ++;
            }
        }
        return sb.toString();
    }

}
