package bitmanipulation;

/**
 * 190. Reverse Bits
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for(int i=0; i<32; i++) {
            int endDigit = n & 1;
            n = n>>1;
            res = res<<1;
            res = res | endDigit;
        }
        return res;
    }

}
