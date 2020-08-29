package array;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int tail = A.length-1;
        while(tail > 0) {
            int curMax = findMax(A, 0, tail);
            if(curMax != tail) {
                //swap max number to head
                if(curMax != 0) {
                    flip(A, curMax + 1);
                    res.add(curMax + 1);
                }
                //swap max number to tail
                flip(A, tail + 1);
                res.add(tail + 1);
            }
            tail --;
        }
        return res;
    }

    private void flip(int[] A, int k) {
        int low = 0;
        int high = k-1;
        while(low < high) {
            int temp = A[low];
            A[low] = A[high];
            A[high] = temp;
            low++;
            high--;
        }
    }

    private int findMax(int[] A, int start, int end) {
        int max = 0;
        int index = -1;
        for(int i=start; i<=end; i++) {
            if(A[i] > max) {
                max = A[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] a = {3,2,4,1};
        PancakeSorting p = new PancakeSorting();
        System.out.println(p.pancakeSort(a));
    }
}
