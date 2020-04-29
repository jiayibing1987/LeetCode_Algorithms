package thirtydayschallenge;

import java.util.*;

public class FirstUnique {
    Queue<Integer> q = new LinkedList<>();
    Map<Integer, Integer> map= new HashMap<Integer, Integer>();

    public FirstUnique(int[] nums) {
        for(int n : nums){
            map.put(n , map.getOrDefault(n, 0) + 1);
            q.add(n);
        }
    }

    public int showFirstUnique() {
        while(!q.isEmpty() && map.get(q.peek()) > 1){
            q.poll();
        }
        return q.isEmpty() ? -1 : q.peek();
    }

    public void add(int value) {
        map.put(value , map.getOrDefault(value, 0) + 1);
        q.add(value);
    }

    public static void main (String[] args) {
        FirstUnique f = new FirstUnique(new int[] {2,3,5});
        System.out.println(f.showFirstUnique());
        f.add(5);
        System.out.println(f.showFirstUnique());
        f.add(2);
        System.out.println(f.showFirstUnique());
        f.add(3);
        System.out.println(f.showFirstUnique());

    }
}
