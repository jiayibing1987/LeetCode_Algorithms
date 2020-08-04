package string;

import java.util.*;

public class ReorderDatainLog {

    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        PriorityQueue<String> pq = new PriorityQueue<>(new LogComparator());
        Queue<String> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            String s = logs[i];
            if (Character.isLetter(s.charAt(s.indexOf(" ") + 1)))
                pq.add(s);
            else
                q.add(s);
        }

        String[] orderedLogs = new String[n];
        int size = pq.size();
        for (int i = 0; i < size; i++)
            orderedLogs[i] = pq.poll();
        for (int j = size; j < n; j++)
            orderedLogs[j] = q.poll();

        return orderedLogs;
    }

    class LogComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            int res = a.substring(a.indexOf(" ") + 1).compareTo(b.substring(b.indexOf(" ") + 1));
            if(res == 0) return a.compareTo(b);
            else return res;
        }
    }
}
