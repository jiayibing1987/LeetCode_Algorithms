package twopointer;

public class LongestMountaininArray {

    public int longestMountain(int[] A) {
        if(A.length < 3) return 0;
        int n = A.length;
        int max = 0;
        for(int i=1; i <= n-2; i++) {
            if(A[i] > A[i-1] && A[i] > A[i+1]) {
                int l = i-1;
                int r = i+1;
                while(l>0 && A[l-1] < A[l])
                    l--;
                while(r<n-1 && A[r+1] < A[r])
                    r++;
                max = Math.max(max, r - l + 1);
            }
        }
        return max;
    }
}
