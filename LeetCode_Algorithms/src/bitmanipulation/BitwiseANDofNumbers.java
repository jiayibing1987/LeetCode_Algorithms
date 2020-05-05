package bitmanipulation;

/**
 * 201. Bitwise AND of Numbers Range
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 */
public class BitwiseANDofNumbers {

    public int rangeBitwiseAnd(int m, int n) {
        int prefix_count = 0;
        /*
        * 5 101
        * 6 110
        * 7 111
        *
        * 4 100 (result)
        * pick the common prefix of number e.g. 1, all the remaining bits are 0
        *
        * */

        while(m != n) {
            m = m >> 1;
            n = n >> 1;
            prefix_count ++;
        }
        return m << prefix_count;
    }

}
