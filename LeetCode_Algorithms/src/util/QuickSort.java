package util;

import java.util.Arrays;

public class QuickSort {

	public void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	public void quickSort(int[] a, int low, int high) {
		if(low >= high)
			return;
		int pivot = partition(a, low, high);
		quickSort(a ,low, pivot);
		quickSort(a ,pivot + 1, high);
	}

	private int partition(int[] a, int low, int high) {
		int p = a[(low + high) / 2];
		int i = low;
		int j = high;

		while(true) {
			while (a[i] < p)
				i++;
			while (a[j] > p)
				j--;
			if (i >= j) break;
			else {
				swap(a, i ,j);
				i++;
				j--;
			}

		}
		return j;
	}

	private void swap (int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

//	public void quickSort(int[] a, int low, int high) {
//		if(low >= high) return;
//		int pivot = partition(a, low, high);
//		quickSort(a, low, pivot - 1);
//		quickSort(a, pivot + 1, high);
//	}
//
//	private int partition(int[] a, int low, int high) {
//		int pivot = a[high];
//		int i = low - 1;
//
//		for (int j = low; j <= high - 1; j++) {
//			if (a[j] < pivot) {
//				i++;
//				// swap a[i] and a[j], move smaller number to index i
//				int temp = a[j];
//				a[j] = a[i];
//				a[i] = temp;
//			}
//		}
//		// swap a[high] and a[i+1]
//		int temp = a[high];
//		a[high] = a[i + 1];
//		a[i + 1] = temp;
//
//		return i + 1;
//	}

	public static void main(String[] args) {
		int[] a = new int[]{3,2,3,1,2,4,5,5,6};
		int[] b = new int[]{5,4,3,2,1};
		int[] c = new int[]{1,2,3,4,5};
		QuickSort qs = new QuickSort();
		qs.sort(a);
		qs.sort(b);
		qs.sort(c);
		System.out.println(Arrays.toString(a));
/*		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));*/
	}

}
