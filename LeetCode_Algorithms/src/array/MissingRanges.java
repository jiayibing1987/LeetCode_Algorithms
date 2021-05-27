package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<>();
        int n = nums.length;
        if(n == 0) {return List.of(generateRange(lower, upper));}

        if(nums[0] > lower) {
            res.add(generateRange(lower, nums[0] - 1));
        }
        for(int i = 0; i < n - 1; i++) {
            if(nums[i + 1] - nums[i] > 1 && nums[i] < upper) {
                int start = Math.max(nums[i] + 1, lower);
                int end = Math.min(nums[i + 1] - 1, upper);
                String range = generateRange(start, end);
                res.add(range);
            }
        }
        if(nums[n- 1] < upper) {
            res.add(generateRange(nums[n - 1] + 1, upper));
        }
        return res;
    }

    private String generateRange(int start, int end) {
        StringBuilder sb = new StringBuilder();
        if(start != end) {
            sb.append(start);
            sb.append("->");
            sb.append(end);
        } else {
            sb.append(start);
        }
        return sb.toString();
    }

}
