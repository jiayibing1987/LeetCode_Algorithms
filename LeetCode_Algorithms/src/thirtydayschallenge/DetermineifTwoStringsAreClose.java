package thirtydayschallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DetermineifTwoStringsAreClose {

    private final int NumberOfLowerCases = 26;

    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int n = word1.length();
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        int[] table1 = new int[NumberOfLowerCases];
        int[] table2 = new int[NumberOfLowerCases];

        for(int i=0; i<n; i++) {
            table1[charArray1[i] - 'a'] ++;
            table2[charArray2[i] - 'a'] ++;
        }

        List<Integer> countList1 = new ArrayList<>();
        List<Integer> countList2 = new ArrayList<>();

        List<Integer> letterList1 = new ArrayList<>();
        List<Integer> letterList2 = new ArrayList<>();

        for(int i=0; i<NumberOfLowerCases; i++){
            if(table1[i] != 0) {
                countList1.add(table1[i]);
                letterList1.add(i);
            }
            if(table2[i] != 0) {
                countList2.add(table2[i]);
                letterList2.add(i);
            }
        }

        if(letterList1.size() != letterList2.size() || countList1.size() != countList2.size())
            return false;

        Collections.sort(letterList1);
        Collections.sort(letterList2);
        if(!letterList1.equals(letterList2)) return false;

        Collections.sort(countList1);
        Collections.sort(countList2);
        return countList1.equals(countList2);
    }

    public static void main(String[] args) {
//        System.out.println(new DetermineifTwoStringsAreClose().closeStrings("abc", "bca"));
//        System.out.println(new DetermineifTwoStringsAreClose().closeStrings("cabbba", "abbccc"));
//        System.out.println(new DetermineifTwoStringsAreClose().closeStrings("cabbba", "aabbss"));
        String a = "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
        String b = "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
        System.out.println(new DetermineifTwoStringsAreClose().closeStrings(a, b));
        List<Integer> countList1 = new ArrayList<>();
        List<Integer> countList2 = new ArrayList<>();

        for(int i =0; i<=1000; i++){
            countList1.add(i);
            countList2.add(i);
            if(!countList1.get(i).equals(countList2.get(i))) {
                System.out.println(countList1.get(i) + " " + countList2.get(i));
            }
        }
    }
}
