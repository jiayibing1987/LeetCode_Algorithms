package twopointer;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        if(A == null || A.length == 0) return A;

        int even = 0;
        int odd = A.length -1;
        while(even < odd) {
            if(A[even] % 2 != 0 && A[odd] % 2 == 0) {
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
                even ++;
                odd --;
            } else {
                if (A[even] % 2 == 0) {
                    even++;
                }
                if (A[odd] % 2 != 0) {
                    odd--;
                }
            }
        }
        return A;
    }

}
