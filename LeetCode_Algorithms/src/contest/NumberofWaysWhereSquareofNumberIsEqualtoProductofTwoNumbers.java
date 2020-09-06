package contest;

import java.util.HashMap;
import java.util.Map;

public class NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbers {

    public int numTriplets(int[] nums1, int[] nums2) {
        int c1 = getCount(nums1, nums2);
        int c2 = getCount(nums2, nums1);
        return c1 + c2;
    }

    private int getCount(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        int count = 0;
        for(int i=0; i<nums1.length; i++) {
            long product = (long)nums1[i] * (long)nums1[i];
            map1.clear();
            for(int j=0; j<nums2.length; j++) {
                if(product % (long)nums2[j] == 0L && map1.containsKey((int) (product / (long)nums2[j]))) {
                    count += map1.get((int) (product / (long)nums2[j]));
                }
                map1.put(nums2[j], map1.getOrDefault(nums2[j], 0) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums1 = {7,4};
        int [] nums2 = {5,2,8,9};

        int [] nums3 = {1,1};
        int [] nums4 = {1,1,1};

        int [] nums5 = {100000,100000};
        int [] nums6 = {100000,100000};
        NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbers n = new NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbers();
        //System.out.println(n.getCount(nums1, nums2));
        //System.out.println(n.numTriplets(nums3, nums4));
        System.out.println(n.numTriplets(nums5, nums6));

    }
}
