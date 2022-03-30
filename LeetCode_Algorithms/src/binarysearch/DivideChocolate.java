package binarysearch;

import java.util.Arrays;

public class DivideChocolate {

    public int maximizeSweetness(int[] sweetness, int k) {
        int low = Integer.MAX_VALUE;
        int high = 1;

        for(int s : sweetness) {
            low = Math.min(low, s);
            high += s;
        }

        while(low < high) {
            int mid = (low + high + 1)/ 2;
            int count = 0;
            int sum = 0;

            for(int s : sweetness) {
                sum += s;
                if(sum >= mid) {
                    count ++;
                    sum = 0;
                }
            }

            if(count < k + 1) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        DivideChocolate d = new DivideChocolate();
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(d.maximizeSweetness(a, 5));
    }
}
