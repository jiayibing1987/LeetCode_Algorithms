package breadthfirstsearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpentheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for(String d : deadends)
            visited.add(d);
        String root = "0000";

        Queue<String> q = new LinkedList<>();
        if(!visited.contains(root)) {
            visited.add(root);
            q.add(root);
        }
        int depth = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String node = q.poll();
                if(node.equals(target)) return depth;

                //generate 8 children for each node
                for(int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder(node);
                    int original = Character.getNumericValue(node.charAt(j));
                    int forward =  original == 9 ? 0 : original+ 1;
                    int backward = original == 0 ? 9 : original - 1;
                    sb.setCharAt(j, Character.forDigit(forward, 10));
                    String s1 = sb.toString();
                    if(!visited.contains(s1)) {
                        q.add(s1);
                        visited.add(s1);
                    }

                    sb.setCharAt(j, Character.forDigit(backward, 10));
                    String s2 = sb.toString();
                    if(!visited.contains(s2)) {
                        q.add(s2);
                        visited.add(s2);
                    }

                }
            }
            depth ++;
        }

        return -1;
    }

    public static void main(String[] args) {
        OpentheLock op = new OpentheLock();
        String[] s1 = new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"};
        System.out.println(op.openLock(s1, "8888"));
    }

}
