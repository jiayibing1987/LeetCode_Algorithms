package contest;

public class WaystoMakeaFairArray {

    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        long[] prefix_odd = new long[n];
        long[] prefix_even = new long[n];
        long[] suffix_odd = new long[n];
        long[] suffix_even = new long[n];

        long sum_odd = 0L;
        long sum_even = 0L;
        for(int i=0; i<n; i++) {
            if(i%2 == 0) {
                sum_even += (long)nums[i];
            }else{
                sum_odd += (long)nums[i];
            }
            prefix_even[i] = sum_even;
            prefix_odd[i] = sum_odd;
        }

        sum_odd = 0;
        sum_even = 0;
        for(int i=n-1; i>=0; i--) {
            if(i%2 == 0) {
                sum_even += (long)nums[i];
            }else{
                sum_odd += (long)nums[i];
            }
            suffix_even[i] = sum_even;
            suffix_odd[i] = sum_odd;
        }

        //if remove i
        int count = 0;
        for(int i=0; i<n; i++) {
            long prefix_odd_sum = 0L;
            long prefix_even_sum = 0L;
            long sufffix_odd_sum = 0L;
            long sufffix_even_sum = 0L;

            if(i - 1 >= 0) {
                prefix_odd_sum = prefix_odd[i-1];
                prefix_even_sum = prefix_even[i-1];
            }

            if(i+1 <= n -1) {
                sufffix_odd_sum = suffix_odd[i+1];
                sufffix_even_sum = suffix_even[i+1];
            }

            if(prefix_odd_sum + sufffix_even_sum == prefix_even_sum + sufffix_odd_sum)
                count ++;
        }

        return count;
    }

    public static void main(String[] args) {
        WaystoMakeaFairArray w = new WaystoMakeaFairArray();
        int[] a = {2,1,6,4};
        int[] b = {1,1,1};
        int[] c = {1,2,3};
        System.out.println(w.waysToMakeFair(a));
        System.out.println(w.waysToMakeFair(b));
        System.out.println(w.waysToMakeFair(c));

    }

}
