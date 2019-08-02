package array;

import java.util.HashMap;
import java.util.Map;

/**
 * #454. 4Sum II
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) 
 * there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * @author Ryan
 *
 */
public class FourSumTwo {

	//create a map to store two sum of A and B
	// for sum of C and D, look for sum(A,B) + sum(C,D) = 0
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count = 0;
		if (A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0)
			return count;
		Map<Integer, Integer> mapAB = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sumAB = A[i] + B[j];
				mapAB.put(sumAB, mapAB.getOrDefault(sumAB, 0) + 1);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sumCD = C[i] + D[j];
				count += mapAB.getOrDefault(0-sumCD, 0);
			}
		}

		return count;
	}

	public static void main(String[] args) {
		FourSumTwo f = new FourSumTwo();
		int[] A = { 1, 2 };
		int[] B = { -2, -1 };
		int[] C = { -1, 2 };
		int[] D = { 0, 2 };
		System.out.print(f.fourSumCount(A, B, C, D));
	}

}
