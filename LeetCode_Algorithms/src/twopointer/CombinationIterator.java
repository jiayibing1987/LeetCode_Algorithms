package twopointer;

import java.util.LinkedList;
import java.util.Queue;

public class CombinationIterator {

    Queue<String> queue;
    public CombinationIterator(String characters, int combinationLength) {
        queue = new LinkedList<>();
        combination(characters, "", 0, combinationLength);
    }

    public void combination(String s, String cur, int start, int length) {
        if(cur.length() == length) {
            queue.add(cur);
            return;
        }
        for(int i=start; i<s.length(); i++) {
            String temp = cur + s.charAt(i);
            combination(s, temp, i+1, length);
        }
    }

    public String next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        CombinationIterator c = new CombinationIterator("abc", 2);
        System.out.print(c.next());
        System.out.print(c.next());
        System.out.print(c.next());
    }
}
