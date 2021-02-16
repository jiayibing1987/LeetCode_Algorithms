package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backTrack(s, 0 , res, "");
        return res;
    }

    public void backTrack(String s, int index, List<String> res, String perm) {
        if(index >= s.length()){
            res.add(perm);
            return;
        }

        char c = s.charAt(index);
        index++;
        if(Character.isLetter(c)) {
            backTrack(s, index, res, perm + String.valueOf(c).toLowerCase());
            backTrack(s, index, res, perm + String.valueOf(c).toUpperCase());
        } else {
            backTrack(s, index, res, perm + c);
        }
    }
}
