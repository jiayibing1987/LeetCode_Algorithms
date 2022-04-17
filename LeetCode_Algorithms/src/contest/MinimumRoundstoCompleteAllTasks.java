package contest;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundstoCompleteAllTasks {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        int res = 0;
        for(int size : map.values()) {
            if (size == 1)
                return -1;
            else if (size % 3 == 0) {
                res += size / 3;
            } else if (size % 3 == 2) {
                res += size / 3;
                res = res + 1;
            } else if (size % 3 == 1) {
                res += size / 3;
                res = res + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumRoundstoCompleteAllTasks m = new MinimumRoundstoCompleteAllTasks();
        int[] t1 = new int[] {2,2,3,3,2,4,4,4,4,4};
        System.out.println(m.minimumRounds(t1));
    }
}
