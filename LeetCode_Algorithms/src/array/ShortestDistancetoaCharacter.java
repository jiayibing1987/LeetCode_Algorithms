package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistancetoaCharacter {

    public int[] shortestToChar(String s, char c) {
        char[] charArray = s.toCharArray();
        List<Integer> charIndexList = new ArrayList<>();

        charIndexList.add(-s.length());
        for(int i=0; i<charArray.length; i++) {
            if(charArray[i] == c)
                charIndexList.add(i);
        }
        charIndexList.add(2*s.length());

        int index = 1;
        int[] res = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            int nextCharIndex = charIndexList.get(index);
            int preCharIndex = charIndexList.get(index-1);
            res[i] = Math.min(i - preCharIndex, nextCharIndex - i);
            if(i == nextCharIndex) {
                index ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestDistancetoaCharacter s = new ShortestDistancetoaCharacter();
        String str = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(s.shortestToChar(str, c)));
    }
}
