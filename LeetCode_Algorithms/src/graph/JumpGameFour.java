package graph;

import java.util.*;

public class JumpGameFour {

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new LinkedList<>());
            }
            map.get(arr[i]).add(i);
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();

                if (node == n - 1) return count;
                List<Integer> chilren = map.get(arr[node]);
                for (int c : chilren) {
                    if (!visited.contains(c)) {
                        q.add(c);
                        visited.add(c);
                    }
                }
                map.get(arr[node]).clear();
                if (node > 0 && !visited.contains(node - 1)) {
                    q.add(node - 1);
                    visited.add(node - 1);
                }
                if (node < n - 1 && !visited.contains(node + 1)) {
                    q.add(node + 1);
                    visited.add(node + 1);
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        JumpGameFour j = new JumpGameFour();
        int[] a1 = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int[] a2 = {7, 6, 9, 6, 9, 6, 9, 7};
        System.out.println(j.minJumps(a1));
        System.out.println(j.minJumps(a2));
    }
}
