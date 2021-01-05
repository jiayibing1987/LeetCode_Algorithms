package array;

public class HowManyNumbersAreSmallerThantheCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int n = nums.length;
        int[] res = new int[n];
        for(int k : nums){
            count[k] ++;
        }

        int c = 0;
        for(int i=0; i<count.length; i++) {
            if(count[i] != 0) {
                int temp = count[i] ;
                count[i] = c;
                c = c + temp;
            }
        }

        for(int i=0; i<res.length; i++) {
            res[i] = count[nums[i]];
        }
        return res;
    }

}
