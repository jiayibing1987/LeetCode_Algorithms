package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleanArray {

    int[] array;
    int[] original;
    Random ran;
    public ShuffleanArray(int[] nums) {
        ran = new Random();
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = new int[array.length];
        original = original.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0; i<array.length; i++) {
            int j = ran.nextInt(array.length -1 - i ) + i ;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

}
