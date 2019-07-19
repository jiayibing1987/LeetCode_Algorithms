package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * #57 Insert Interval
 * @author Ryan
 *
 */
public class InsertInterval {

	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<int[]>();
		if (intervals.length == 0) {
			result.add(newInterval);
			return result.toArray(new int[result.size()][]);
		}
		boolean isAdded = false;
		for (int i=0; i<intervals.length; i++) {
			int[] interval = intervals[i];
			// interval overlaps need merge, if the merge one is the last one then add to result
			if (overlaps(interval, newInterval)) {
				newInterval[0] = Math.min(interval[0], newInterval[0]);
				newInterval[1] = Math.max(interval[1], newInterval[1]);
				if(i==intervals.length-1)
					result.add(newInterval);
			} else {
				if (newInterval[1] < interval[0] && !isAdded) {
					result.add(newInterval);
					isAdded = true;
				}
				result.add(interval);
				//if it is last interval and still not overlaping then add new interval in the end
				if(i==intervals.length-1 && newInterval[0] > interval[1] && !isAdded){
					result.add(newInterval);
				}
			}
		}
		return result.toArray(new int[result.size()][]);
	}

	private boolean overlaps(int[] a, int[] b) {
		if (b[0] <= a[1] && b[1] >= a[0]) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		InsertInterval in = new InsertInterval();
		int[][] a = { { 1, 5 } };
		int[] newa = { 6, 8 };
		//System.out.println(Arrays.deepToString(in.insert(a, newa)));

		int[][] b = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] b1 = { 4, 8 };
		// System.out.println(Arrays.deepToString(in.insert(b, b1)));

		int[][] c = { { 0, 2 }, {3, 9} };
		int[] c1 = { 6, 8 };
		System.out.println(Arrays.deepToString(in.insert(c, c1)));
	}

}
