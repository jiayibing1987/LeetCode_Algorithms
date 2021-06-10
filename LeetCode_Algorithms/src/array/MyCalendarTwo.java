package array;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {
    List<int[]> calendar;
    List<int[]> overlaps;

    MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] iv: overlaps) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1])
                overlaps.add(new int[]{Math.max(start, iv[0]), Math.min(end, iv[1])});
        }
        calendar.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo MyCalendar = new MyCalendarTwo();
//        System.out.println(MyCalendar.book(10, 20));
//        System.out.println(MyCalendar.book(50, 60));
//        System.out.println(MyCalendar.book(10, 40)) ; // returns true
//        System.out.println(MyCalendar.book(5, 15)); // returns false
//        System.out.println(MyCalendar.book(5, 10)); // returns true
//        System.out.println(MyCalendar.book(25, 55)); // returns true

        System.out.println(MyCalendar.book(26,35));
        System.out.println(MyCalendar.book(26,32));
        System.out.println(MyCalendar.book(25,32)) ;
        System.out.println(MyCalendar.book(18,26));
        System.out.println(MyCalendar.book(40,45));
        System.out.println(MyCalendar.book(19,26));
    }
}
