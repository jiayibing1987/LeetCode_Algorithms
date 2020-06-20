package math;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        List<Integer> nums = new ArrayList<>();
        //list for numbers {1,2,3,4,...n}
        for(int i=0; i<=n; i++)
            nums.add(i);
        //set factorial for each number
        for(int i=1; i<=n; i++)
            factorial[i] = factorial[i-1] * i;

        StringBuilder sb = new StringBuilder();
        int numberOfBlock = n;
        for(int i=1; i<=n; i++) {
            int sizeOfBlock = factorial[numberOfBlock] / numberOfBlock;
            int index = (int) Math.ceil ((double)k / (double)sizeOfBlock);
            k = k - ((index-1) * sizeOfBlock);

            sb.append(nums.get(index));
            nums.remove(index);
            numberOfBlock--;
        }
        return sb.toString();
    }

    public static void main (String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3,3));
    }
}
