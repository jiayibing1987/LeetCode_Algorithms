package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IntersectionofTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Set<Integer> set = new HashSet<Integer>();
		int n1 = nums1.length;
		int n2 = nums2.length;
		int i = 0;
		int j = 0;
		while (i < n1 && j < n2) {
			if (nums1[i] == nums2[j]) {
				set.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		int[] result = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		for(int k=0; k<result.length; k++){
			result[k] = (int) iterator.next();
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = {4,5,9};
		int[] nums2 = {4,4,8,9,9};
		IntersectionofTwoArrays i = new IntersectionofTwoArrays();
		System.out.println(Arrays.toString(i.intersection(nums1, nums2)));
	}

}
