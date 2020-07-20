package graph;

import java.util.*;

public class CourseScheduleTwo {

    boolean foundCycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = initGraph(numCourses, prerequisites);

        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean[]  inStack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!visited[i])
                dfs(i, visited, stack, inStack, graph);
        }

        return foundCycle? new int[0] : toArray(stack);
    }

    private int[] toArray(Stack<Integer> stack) {
        int[] array = new int[stack.size()];
        for(int i=0; i<array.length; i++) {
            array[i] = stack.pop();
        }
        return array;
    }

    private List<Integer>[] initGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for(int[] edge : prerequisites) {
            int pre = edge[1];
            if(graph[pre] == null) {
                graph[pre] = new ArrayList<>();
            }
            graph[pre].add(edge[0]);
        }
        return graph;
    }

    private void dfs(int index, boolean[] visited, Stack<Integer> stack, boolean[] inStack, List<Integer>[] graph) {
        if(visited[index] && !inStack[index]){
            foundCycle = true;
            return;
        }

        visited[index] = true;

        if(graph[index] != null) {
            for (int child : graph[index]) {
                if (!inStack[child])
                    dfs(child, visited, stack, inStack, graph);
            }
        }
        stack.push(index);
        inStack[index] = true;
    }

    public static void main(String[] args) {
        CourseScheduleTwo c = new CourseScheduleTwo();
        int[][] prerequisites= {{0,1}, {1,0}};
        System.out.print(Arrays.toString(c.findOrder(2, prerequisites)));
    }

}
