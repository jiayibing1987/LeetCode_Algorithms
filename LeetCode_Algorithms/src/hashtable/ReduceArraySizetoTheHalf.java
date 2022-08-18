package hashtable;

import java.util.HashMap;
import java.util.Map;

public class ReduceArraySizetoTheHalf {

    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int maxCount = 0;
        for(int num : arr) {
            int count = freq.getOrDefault(num, 0) + 1;
            freq.put(num, count);
            maxCount = Math.max(maxCount, count);
            //System.out.println(count + " " + maxCount);
        }

        int[] bucket = new int[maxCount + 1];
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            bucket[count] ++;
        }

        int ans = 0;
        int remain = n;
        for(int count = bucket.length - 1; count > 0; count--) {
            if(bucket[count] > 0) {
                System.out.println("freq: " + count + " nums: " + bucket[count]);
                int maxRemove = remain - (n / 2);
                int numberToRemove = maxRemove / count;
                System.out.println(numberToRemove);
                if(numberToRemove == 0 || (maxRemove % count) != 0)
                    numberToRemove ++;
                int actualRemoved = Math.min(numberToRemove, bucket[count]);
                ans += actualRemoved;
                System.out.println("remain " + remain + " maxRemove: " + maxRemove + " numberToRemove: " + numberToRemove + " actualRemoved: " + actualRemoved);
                remain -= actualRemoved * count;
                if(numberToRemove <= bucket[count])
                    return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ReduceArraySizetoTheHalf r = new ReduceArraySizetoTheHalf();
        System.out.println(r.minSetSize(new int[] {1000,1000,3,7}));
    }
}
