package thirtydayschallenge;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        StringBuilder sb = new StringBuilder();
        String[] array = new String[nums.length];
        for(int i=0; i<nums.length; i++)
            array[i] = String.valueOf(nums[i]);
        Arrays.sort(array, new StringComparator());

        for(int i=nums.length-1; i>=0; i--)
            sb.append(array[i]);

        return trimLeadingZeros(sb.toString());
    }

    public static String trimLeadingZeros(String source) {
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c != '0') {
                return source.substring(i);
            }
        }
        return "0";
    }

    class StringComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return  (int)(Long.valueOf(a + b) - Long.valueOf(b+a));
        }
    }
}
