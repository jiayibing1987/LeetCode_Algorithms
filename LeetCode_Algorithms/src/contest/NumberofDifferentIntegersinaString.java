package contest;

import java.util.HashSet;
import java.util.Set;

public class NumberofDifferentIntegersinaString {

    public int numDifferentIntegers(String word) {
        int n = word.length();
        Set<String> set = new HashSet<>();

        char[] a = new char[n];
        for(int i = 0; i< n; i++) {
            char c = word.charAt(i);
            if(Character.isDigit(c)) {
                a[i] = c;
            } else {
                a[i] = ' ';
            }
        }

        String s = new String(a).trim();
        if(s.isEmpty()) return 0;
        String[] array = s.split("\\s+");
        for(String num : array) {
            set.add(trimLeadingZeros(num));
        }
        return set.size();
    }

    public static String trimLeadingZeros(String source) {
        for (int i = 0; i < source.length(); ++i) {
            char c = source.charAt(i);
            if (c != '0') {
                return source.substring(i);
            }
        }
        return ""; // or return "0";
    }

    public static void main(String[] args) {
        NumberofDifferentIntegersinaString n = new NumberofDifferentIntegersinaString();
        System.out.println(n.numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(n.numDifferentIntegers("a1b01c001"));
        System.out.println(n.numDifferentIntegers("123"));
        System.out.println(n.numDifferentIntegers("abc"));
        System.out.println(n.numDifferentIntegers("167278959591294"));

    }
}
