package contest;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

public class MinimumOperationstoMaketheArrayAlternating {

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int evenLen = n % 2 == 0 ? n / 2 : (n / 2) + 1;
        int oddLen = n / 2;

        Map<Integer, Integer> mapEven = new HashMap<>();
        Map<Integer, Integer> mapOdd = new HashMap<>();
        int max1 = 0; int num1 = 0;
        int max2 = 0; int num2 = 0;

        for(int i = 0; i < n; i ++) {
            if(i % 2 == 0) {
                mapEven.put(nums[i], mapEven.getOrDefault(nums[i], 0) + 1);
                int count = mapEven.get(nums[i]);
                if(count > max1) {
                    num1 = nums[i];
                    max1 = count;
                }
            } else {
                mapOdd.put(nums[i], mapOdd.getOrDefault(nums[i], 0) + 1);
                int count = mapOdd.get(nums[i]);
                if(mapOdd.get(nums[i]) > max2) {
                    num2 = nums[i];
                    max2 = count;
                }
            }
        }

        if(num1 != num2) {
            int op1 = evenLen - max1;
            int op2 = oddLen - max2;
            return op1 + op2;
        } else {
            //find out second max
            int secondMax1 = 0;
            int secondMax2= 0;

            for(Map.Entry<Integer, Integer> e : mapEven.entrySet()) {
                int num = e.getKey();
                int count = e.getValue();
                if(count > secondMax1 && num != num1) {
                    secondMax1 = count;
                }
            }

            for(Map.Entry<Integer, Integer> e : mapOdd.entrySet()) {
                int num = e.getKey();
                int count = e.getValue();
                if(count > secondMax2 && num != num2) {
                    secondMax2 = count;
                }
            }

            //pick second max for even
            int sop1 = evenLen - secondMax1;
            int op2 = oddLen - max2;

            int op1 = evenLen - max1;
            int sop2 = oddLen - secondMax2;
            return Math.min(sop1 + op2, op1 + sop2);
        }
    }

    public static void main(String[] args) {
        MinimumOperationstoMaketheArrayAlternating m = new MinimumOperationstoMaketheArrayAlternating();
        //int[] a = new int[] {3,1,3,2,4,3};
        int[] b = new int[] {1,2,2,2,2};
        //System.out.println(m.minimumOperations(a));
        System.out.println(m.minimumOperations(b));
    }
}
