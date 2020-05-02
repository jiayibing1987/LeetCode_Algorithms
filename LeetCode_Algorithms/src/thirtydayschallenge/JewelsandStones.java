package thirtydayschallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JewelsandStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for(char c: J.toCharArray())
            set.add(c);
        int res = 0;
        for(char c : S.toCharArray()){
            if(set.contains(c))
                res++;
        }
        return res;
    }

}
