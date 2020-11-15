package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class OrderedStream {

    PriorityQueue<Pair> pq;
    int count;
    public OrderedStream(int n) {
        count = 1;
        pq = new PriorityQueue<>(n);
    }

    public List<String> insert(int id, String value) {
        List res = new ArrayList<String>();
        pq.add(new Pair(id, value));
        while(!pq.isEmpty() && pq.peek().id == count) {
            Pair p = pq.poll();
            res.add(p.value);
            count++;
        }
        return res;
    }

    public class Pair implements Comparable<Pair> {
        int id;
        String value;

        public Pair(int id, String value) {
            this.id = id;
            this.value = value;
        }
        @Override
        public int compareTo(Pair p) {
            return Integer.compare(this.id, p.id);
        }
    }
}
