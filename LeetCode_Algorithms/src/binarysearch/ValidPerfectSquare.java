package binarysearch;

/**
 * 367. Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = num;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            long temp = (long)mid * (long)mid;
            if(temp == num) return true;
            else if(temp > num) high = mid - 1;
            else low = mid+1;
        }
        return false;
    }

}
