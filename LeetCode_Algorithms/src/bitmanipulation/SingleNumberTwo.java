package bitmanipulation;

/**
 * 137. Single Number II
 */
public class SingleNumberTwo {

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0; i<32; i++) {
            int sum = 0;
            for(int n : nums) {
                if((n >> i & 1) == 1)
                    sum ++;
            }
            sum = sum % 3;
            res |= sum<<i;
        }
        return res;
    }
}
