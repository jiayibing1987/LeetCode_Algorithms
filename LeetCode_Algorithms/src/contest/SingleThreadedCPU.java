package contest;

import java.util.*;

public class SingleThreadedCPU {

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        PriorityQueue<Task> pendgingTasks = new PriorityQueue<Task>( (a, b) -> ((Task) a).enqueueTime - ((Task) b).enqueueTime);
        PriorityQueue<Task> availableTasks = new PriorityQueue<Task>((a, b) -> ((Task) a).processingTime == ((Task) b).processingTime ?
                ((Task) a).index - ((Task) b).index : ((Task) a).processingTime - ((Task) b).processingTime);
        for(int i = 0; i < tasks.length; i++) {
            pendgingTasks.add(new Task(tasks[i][0], tasks[i][1], i));
        }

        int[] res = new int[n];
        int timer = 0;
        int i = 0;
        while(!pendgingTasks.isEmpty() || !availableTasks.isEmpty()) {
            while(!pendgingTasks.isEmpty() && pendgingTasks.peek().enqueueTime <= timer) {
                availableTasks.add(pendgingTasks.poll());
            }

            if(!availableTasks.isEmpty()) {
                Task processedTask = availableTasks.poll();
                timer += processedTask.processingTime;
                res[i++] = processedTask.index;
            } else {
                timer = pendgingTasks.peek().enqueueTime;
            }
        }
        return res;
    }

    class Task {
        int enqueueTime;
        int processingTime;
        int index;

        public Task (int a, int b, int c) {
            this.enqueueTime = a;
            this.processingTime = b;
            this.index = c;
        }
    }

    public static void main(String[] args) {
        SingleThreadedCPU s = new SingleThreadedCPU();
        int[][] t1 = {{1,2},{2,4},{3,2},{4,1}};
        System.out.println(Arrays.toString(s.getOrder(t1)));
        int[][] t2 = {{7,10},{7,12},{7,5},{7,4},{7,2}};
        System.out.println(Arrays.toString(s.getOrder(t2)));
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
