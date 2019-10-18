package util;

import java.util.Arrays;

public class QuickSort {

	public void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	public void quickSort(int[] a, int low, int high) {
		if(low >= high) return;
		int pivot = partition(a, low, high);
		quickSort(a, low, pivot - 1);
		quickSort(a, pivot + 1, high);
	}

	private int partition(int[] a, int low, int high) {
		int pivot = a[high];
		int i = low - 1;

		for (int j = low; j <= high - 1; j++) {
			if (a[j] < pivot) {
				i++;
				// swap a[i] and a[j], move smaller number to index i
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		// swap a[high] and a[i+1]
		int temp = a[high];
		a[high] = a[i + 1];
		a[i + 1] = temp;

		return i + 1;
	}

	public static void main(String[] args) {
		int[] a = new int[]{5,1,4,2,3};
		QuickSort qs = new QuickSort();
		qs.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
