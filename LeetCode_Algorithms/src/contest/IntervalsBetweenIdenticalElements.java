package contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntervalsBetweenIdenticalElements {

    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] res = new long[n];
        long[] leftSum = new long[n];
        long[] rightSum = new long[n];
        long[] leftCount = new long[n];
        long[] rightCount = new long[n];

        Map<Integer, Integer> preIndexMap = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            int value = arr[i];
            if(!preIndexMap.containsKey(value)) {
                leftCount[i] = 0;
                leftSum[i] = 0;
                preIndexMap.put(value, i);
            } else {
                int preIndex = preIndexMap.get(value);
                leftCount[i] = leftCount[preIndex] + 1;
                long d = i - preIndex;
                leftSum[i] = leftSum[preIndex] + d * leftCount[i];
                preIndexMap.put(value, i);
            }
        }

        preIndexMap = new HashMap<>();
        for(int i = n - 1; i >= 0; i --) {
            int value = arr[i];
            if(!preIndexMap.containsKey(value)) {
                rightCount[i] = 0;
                rightSum[i] = 0;
                preIndexMap.put(value, i);
            } else {
                int preIndex = preIndexMap.get(value);
                rightCount[i] = rightCount[preIndex] + 1;
                long d = preIndex - i;
                rightSum[i] = rightSum[preIndex] + d * rightCount[i];
                preIndexMap.put(value, i);
            }
        }

        for(int i = 0; i < n; i ++) {
            res[i] = leftSum[i] + rightSum[i];
        }
        return res;
    }

    public static void main(String[] args) {
        IntervalsBetweenIdenticalElements in = new IntervalsBetweenIdenticalElements();
        int[] a1 = new int[] {2,1,3,1,2,3,3};
        System.out.println(Arrays.toString(in.getDistances(a1)));
    }
}
