package contest;

import java.util.*;

public class CountWordsObtainedAfterAddingaLetter {

    public int wordCount(String[] startWords, String[] targetWords) {
        int count = 0;
        Map<Integer, Set<String>> startMap = new HashMap<>();
        for(String startWord : startWords) {
            int size = startWord.length();
            startWord = sortString(startWord);
            if(!startMap.containsKey(size)) {
                startMap.put(size, new HashSet<>());
            }
            startMap.get(size).add(startWord);
        }

        for(String targetWord : targetWords) {
            targetWord = sortString(targetWord);
            int size = targetWord.length();
            if(!startMap.containsKey(size - 1)) continue;
            Set<String> targetWordsSet = startMap.get(size - 1);
            for(int i = 0; i < targetWord.length(); i ++) {
                String targetRemovedOneChar = targetWord.substring(0, i) + targetWord.substring(i + 1);
                if(targetWordsSet.contains(targetRemovedOneChar)) {
                    count ++;
                    break;
                }
            }
        }
        return count;
    }

    public String sortString (String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        CountWordsObtainedAfterAddingaLetter c = new CountWordsObtainedAfterAddingaLetter();
        String[] s1 = new String[] {"ant","act","tack"};
        String[] t1 = new String[] {"tack","act","acti"};
        System.out.println(c.wordCount(s1, t1));
    }
}
