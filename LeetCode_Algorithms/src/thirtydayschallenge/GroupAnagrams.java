package thirtydayschallenge;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(map.containsKey(sorted))
                map.get(sorted).add(s);
            else{
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(sorted, list);
            }
        }
        res.addAll(map.values());
        return res;
    }
}
