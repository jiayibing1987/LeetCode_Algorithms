package contest;

import java.util.ArrayList;
import java.util.List;

public class FindXORSumofAllPairsBitwiseAND {

    public int getXORSum(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2.length; j++) {
                list.add(arr1[i] & arr2[j]);
            }
            for(int num : list)
                sum = sum ^ num;
            list.clear();
        }

        return sum;
    }

    public static void main (String[] args) {
        FindXORSumofAllPairsBitwiseAND f = new FindXORSumofAllPairsBitwiseAND();
        System.out.println(f.getXORSum(new int[] {1, 2, 3}, new int[] {6, 5}));
        System.out.println(f.getXORSum(new int[] {12}, new int[] {4}));
    }
}
