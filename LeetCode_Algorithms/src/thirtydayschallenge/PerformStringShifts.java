package thirtydayschallenge;

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 */
public class PerformStringShifts {

    public String stringShift(String s, int[][] shift) {
        int countLeft = 0;
        for(int[] a : shift)
            countLeft = a[0] == 0 ? countLeft + a[1] : countLeft - a[1];
        int count = Math.abs(countLeft) % s.length();
        if(countLeft > 0)
            return s.substring(count) + s.substring(0, count);
        else
            return s.substring(s.length() - count) + s.substring(0, s.length() - count);
    }

}
