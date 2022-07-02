package greedy;

import contest.MaximumScoreOfSplicedArray;

import java.util.*;

public class MaximumSplitofPositiveEven {

    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum % 2 != 0)
            return new ArrayList<>();

        LinkedList<Long> list = new LinkedList<>();
        for(long i = 1; finalSum > 0 ; i ++) {
            long even = i * 2;
            if(finalSum < even) {
                finalSum += list.removeLast();
                list.add(finalSum);
                break;
            }
            list.add(even);
            finalSum -= even;

        }
        return list;
    }

    public static void main(String[] args) {
        MaximumSplitofPositiveEven m = new MaximumSplitofPositiveEven();
        System.out.println(m.maximumEvenSplit(28));
    }

}
