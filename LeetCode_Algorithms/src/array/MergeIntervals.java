package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * #56 Given a collection of intervals, merge all overlapping intervals.
 * @author Ryan
 *
 */
public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;
		//sort by first column
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		int[] mergedInterval = intervals[0];
		List<int[]> result = new ArrayList<int[]>();

		for (int[] currentInterval : intervals) {
			// need merge
			if (currentInterval[0] <= mergedInterval[1]) {
				mergedInterval[1] = Math.max(mergedInterval[1], currentInterval[1]);
			} else {
				result.add(mergedInterval);
				mergedInterval = currentInterval;
			}
		}
		result.add(mergedInterval);
		return result.toArray((new int[result.size()][]));
	}

	public static void main(String[] args) {
		MergeIntervals m = new MergeIntervals();
		int[][] a = { { 1, 4 }, { 4, 5 } };
		int[][] b = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		System.out.println(Arrays.deepToString(m.merge(b)));
	}

}
