package design;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {

    private final int MAX_REQUEST;
    private final int TIME_RANGE;

    private Queue<Long> queue = new LinkedList<>();
    public RateLimiter(int max_request, int time_range) {
        MAX_REQUEST = max_request;
        TIME_RANGE = time_range;
    }

    public boolean rateLimit() {
        long curTime = System.currentTimeMillis();
        long boundTime = curTime - TIME_RANGE;
        while(!queue.isEmpty() && queue.peek() <= boundTime )
            queue.poll();
        queue.add(curTime);

        return queue.size() <= MAX_REQUEST;
    }

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(dateFormat.format(new Date()));
    }
}


