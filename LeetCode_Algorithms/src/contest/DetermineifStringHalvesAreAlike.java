package contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineifStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int n = s.length();
        int mid = n / 2;
        String s1 = s.substring(0, mid);
        String s2 = s.substring(mid);

        int count1 = count(set, s1);
        int count2 = count(set, s2);
        return count1 == count2;
    }

    private int count (Set<Character> set, String a) {
        int count = 0;
        for(char c : a.toCharArray()) {
            if(set.contains(c))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        DetermineifStringHalvesAreAlike d = new DetermineifStringHalvesAreAlike();
        System.out.println(d.halvesAreAlike("book"));
        System.out.println(d.halvesAreAlike("textbook"));
        System.out.println(d.halvesAreAlike("MerryChristmas"));
        System.out.println(d.halvesAreAlike("AbCdEfGh"));
    }
}
