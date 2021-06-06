package contest;

import java.util.*;

public class ReductionOperationstoMaketheArrayElementsEqual {

    public int reductionOperations(int[] nums) {
        int n = nums.length;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            list.add(entry.getValue());
        }

        int sum = 0;
        int pre = 0;
        for(int i = list.size() - 1; i > 0; i-- ) {
            int cur = list.get(i);
            int newN = cur + pre;
            pre = newN;
            sum += newN;
        }

        return sum;
    }

    public static void main(String[] args) {
        ReductionOperationstoMaketheArrayElementsEqual r = new ReductionOperationstoMaketheArrayElementsEqual();
        int[] a1 = new int[] {7,9,10,8,6,4,1,5,2,3};
        System.out.println(r.reductionOperations(a1));
    }

}
