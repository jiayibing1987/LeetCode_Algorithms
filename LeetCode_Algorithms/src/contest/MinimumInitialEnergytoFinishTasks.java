package contest;

import java.util.PriorityQueue;

public class MinimumInitialEnergytoFinishTasks {

    public int minimumEffort(int[][] tasks) {
        int sum_actual = 0;
        int max_minReq = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[1] - b[0]) - (a[1] - a[0]) );
        for(int[] task : tasks)
            pq.add(task);

        int curEnergy = 0;
        int diff = 0;
        while(!pq.isEmpty()) {
            int[] task = pq.poll();
            if(curEnergy < task[1]) {
                diff += task[1] - curEnergy;
                curEnergy = task[1];
            }
            curEnergy -= task[0];
        }

        return diff;
    }

    public static void main(String[] args) {
        MinimumInitialEnergytoFinishTasks m = new MinimumInitialEnergytoFinishTasks();
        int[][] a = {{1,7},{2,8},{3,9},{4,10},{5,11},{6,12}};
        System.out.println(m.minimumEffort(a));
       // System.out.println(s.getSmallestString(5, 73));

    }

}
