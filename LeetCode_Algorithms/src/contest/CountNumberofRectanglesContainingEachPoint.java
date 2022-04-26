package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CountNumberofRectanglesContainingEachPoint {

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[] heights = new List[101];
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[0]));
        for(int[] r : rectangles) {
            int x = r[0];
            int y = r[1];
            if(heights[y] == null) {
                heights[y] = new ArrayList<>();
            }
            heights[y].add(x);
        }

        int[] res = new int[points.length];

        for(int i = 0; i < points.length; i ++) {
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            int count = performBinarySearch(heights, x, y);
            res[i] = count;
        }
        return res;
    }

    private int performBinarySearch(List<Integer>[] heights, int x, int y) {
        int count = 0;
        for(int i = y; i < heights.length; i ++) {
            List<Integer> list = heights[i];
            if(list != null) {
                int low = 0;
                int high = list.size() - 1;
                while(low < high) {
                    int mid = low + (high - low) / 2;
                    if(x <= list.get(mid)) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                if(list.get(low) < x)
                    low ++;
                count += list.size() - low;
            }
        }
        return count;
    }
}
