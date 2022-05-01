package contest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KDivisibleElementsSubarrays {

    Set<String> ans;
    public int countDistinct(int[] nums, int k, int p) {
        ans =  new HashSet<>();
        int n = nums.length;
        int[] prefix = new int[n];
        int count = 0;
        for(int i = 0; i < n; i ++) {
            if(nums[i] % p == 0)
                count ++;
            prefix[i] = count;
        }

        for(int i = 0; i < n; i ++) {
            String s = "";
            for(int j = i; j < n; j ++) {
                if(prefix[j] - (i == 0 ? 0 : prefix[i - 1]) <= k) {
                    s += " " + nums[j];
                    ans.add(s);
                } else {
                    break;
                }
            }
        }
        return ans.size();
    }

    public static void main(String[] args) {
        KDivisibleElementsSubarrays kd = new KDivisibleElementsSubarrays();
        int[] a1 = new int[] {2,3,3,2,2};
        System.out.println(kd.countDistinct(a1, 2, 2));
    }

}
