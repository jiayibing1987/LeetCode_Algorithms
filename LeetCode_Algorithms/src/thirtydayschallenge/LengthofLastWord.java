package thirtydayschallenge;

import java.util.ArrayList;
import java.util.List;

public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();

        int res = 0;
        for(int i=s.length()-1; i >=0; i--) {
            if(chars[i] == ' ' && res != 0) {
                return res;
            }else if(chars[i] != ' ')
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        LengthofLastWord w = new LengthofLastWord();
        System.out.print(w.lengthOfLastWord("a"));
    }
}
