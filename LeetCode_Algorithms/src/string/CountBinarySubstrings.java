package string;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        if(s == null || s.length() <= 1) return 0;
        char pre = s.charAt(0);
        int count = 1;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(cur != pre) {
                list.add(count);
                count = 0;
            }
            count ++;
            pre = cur;
        }
        list.add(count);

        int res = 0;
        for(int i = 0; i<list.size()-1; i++) {
            res += Math.min(list.get(i), list.get(i+1));
        }
        return res;
    }

    public static void main(String[] args) {
        CountBinarySubstrings c = new CountBinarySubstrings();
        System.out.println(c.countBinarySubstrings("00110"));
    }
}
