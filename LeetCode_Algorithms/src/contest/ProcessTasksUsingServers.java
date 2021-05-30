package contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ProcessTasksUsingServers {

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] res = new int[m];
        int timer = 0;
        int taskIndex = 0;
        PriorityQueue<Server> avaServers = new PriorityQueue<>((a, b) -> a.weight == b.weight ? a.index - b.index : a.weight - b.weight);
        PriorityQueue<Server> onHoldServers = new PriorityQueue<>((a, b) -> a.avaTime - b.avaTime);

        for(int i = 0; i < n; i++) {
            avaServers.add(new Server(i, servers[i]));
        }

        while(taskIndex < m) {
            while(!onHoldServers.isEmpty() && onHoldServers.peek().avaTime <= timer) {
                avaServers.add(onHoldServers.poll());
            }
            if(avaServers.isEmpty()) {
                timer = onHoldServers.peek().avaTime;
            } else {
                //check if there is a server and a task is available at current time
                while(!avaServers .isEmpty() && timer >= taskIndex) {
                    Server server = avaServers.poll();
                    server.avaTime = timer + tasks[taskIndex];
                    res[taskIndex] = server.index;
                    onHoldServers.add(server);
                    taskIndex++;
                    if(taskIndex  >= m) break;
                }
                timer ++;
            }
        }
        return res;
    }

    public int[] assignTasks1(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] res = new int[m];
        //int timer = 0;
        int taskIndex = 0;
        PriorityQueue<Server> avaServers = new PriorityQueue<>((a, b) -> a.weight == b.weight ? a.index - b.index : a.weight - b.weight);
        PriorityQueue<Server> onHoldServers = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            avaServers.add(new Server(i, servers[i]));
        }

        for(; taskIndex < m; taskIndex ++) {
            while(!onHoldServers.isEmpty() && onHoldServers.peek().avaTime <= taskIndex ) {
                avaServers.add(onHoldServers.poll());
            }
            if(!avaServers .isEmpty()) {
                Server server = avaServers.poll();
                server.avaTime = taskIndex + tasks[taskIndex];
                res[taskIndex] = server.index;
                onHoldServers.add(server);
            } else {
                Server server = onHoldServers.poll();
                server.avaTime += tasks[taskIndex];
                res[taskIndex] = server.index;
                onHoldServers.add(server);
            }

        }
        return res;
    }

     class Server implements Comparable<Server>{
        int index;
        int weight;
        int avaTime;

        public Server(int i, int w) {
            this.index = i;
            this.weight = w;
            avaTime = 0;
        }

         @Override
         public int compareTo(Server server) {
            if(this.avaTime != server.avaTime) {
                return Integer.compare(this.avaTime, server.avaTime);
            } else if (this.weight != server.weight) {
                 return Integer.compare(this.weight, server.weight);
             } else {
                 return Integer.compare(this.index, server.index);
             }
         }
     }

    public static void main(String[] args) {
        ProcessTasksUsingServers p = new ProcessTasksUsingServers();
        int[] s1 = new int[] {3,3,2};
        int[] t1 = new int[] {1,2,3,2,1,2};
        System.out.println(Arrays.toString(p.assignTasks(s1, t1)));

        int[] s2 = new int[] {5,1,4,3,2};
        int[] t2 = new int[] {2,1,2,4,5,2,1};
        System.out.println(Arrays.toString(p.assignTasks(s2, t2)));
    }
}
