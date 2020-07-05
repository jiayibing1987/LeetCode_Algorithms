package bitmanipulation;

/**
 * 461. Hamming Distance
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int mask = 1;
        int count = 0;
        //same as find 1 bits in number
        for(int i=1; i<=32; i++) {
            int temp = xor & mask;
            if(temp != 0) count ++;
            mask = mask << 1;
        }
        return count;
    }

}
