package thirtydayschallenge;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(nums[i], min);
            left[i] = min;
        }

        int max = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            max = Math.max(nums[i], max);
            right[i] = max;
        }

        for(int i=1; i<n-1; i++){
            if(left[i] < nums[i] && right[i] > nums[i])
                return true;
        }
        return false;
    }

    public static void main (String[] args) {
        IncreasingTripletSubsequence in = new IncreasingTripletSubsequence();
        int[] a = new int[]{1,2,3,4,5};
        System.out.print(in.increasingTriplet(a));
    }
}
