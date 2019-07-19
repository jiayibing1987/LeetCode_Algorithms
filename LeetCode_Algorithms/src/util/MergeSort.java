package util;

import java.util.Arrays;

public class MergeSort {

	//Divide the unsorted list into n sublists, each containing a element.
	//sort adjacent pairs of two singleton lists and merge them 
	public void merge_sort(int A[], int start, int end) {
		if(start < end){
			int m = (start+end)/2;
			merge_sort(A, start, m);
			merge_sort(A, m+1, end);
			//merge two sub-sorted array
			merge(A, start, m, end);
		}
	}
	
	//merge two sorted sub-array into one
	public void merge(int a[], int start, int mid, int end){
		int[] temp = new int[end-start+1];
		int p1 = start;
		int p2 = mid+1;
		int k = 0;
		
		for(int i=start; i<=end; i++){
			if(p1>mid){
				temp[k++] = a[p2++];
			}else if(p2>end){
				temp[k++] = a[p1++];
			}else if(a[p1] < a[p2]){
				temp[k++] = a[p1++];
			}else{
				temp[k++] = a[p2++];
			}
		}
		
		//copy temp to array
		int length = end - start + 1;
		for(int i=0; i<length; i++){
			a[start++] = temp[i];
		}
	}

	public static void main(String[] args) {
		int[] a = {9,7,8,3,2,1};
		MergeSort m = new MergeSort();
		m.merge_sort(a, 0, a.length-1);
		System.out.println(  Arrays.toString(a));
	}

}
