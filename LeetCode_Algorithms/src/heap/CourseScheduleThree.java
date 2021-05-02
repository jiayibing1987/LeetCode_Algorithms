package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleThree {

    public int scheduleCourse(int[][] courses) {
        //pq with intervals sort by duration
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        //sort course by last day
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));

        int cur_day = 0;
        for(int[] course : courses) {
            int lastday = course[1];
            int duration = course[0];
            if(cur_day + duration <= lastday) {
                pq.add(course);
                cur_day += duration;
            } else if (!pq.isEmpty() && pq.peek()[0] > duration ) {
                int[] longerCourse = pq.poll();
                pq.add(course);
                cur_day = cur_day - longerCourse[0] + duration ;
            }
        }
        return pq.size();
    }

}
