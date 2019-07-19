package binarysearch;

public class MedianofTwoSortedArrays {

	//O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
    	int[] merged = new int[m+n];
    	int p1 = 0, p2 = 0;
    	for(int i=0; i<m+n; i++){
    		if(p1<m && p2<n ){
    			if(nums1[p1]<nums2[p2])
    				merged[i] = nums1[p1++];
    			else
        			merged[i] = nums2[p2++];
    		}
    		else if(p1 >= m){
    			merged[i] = nums2[p2++];
    		}else if(p2 >= n){
    			merged[i] = nums1[p1++];
    		}
    	}
    	int mid = (m+n)/2;
    	if((m+n)%2 == 0){
    		return ((double)merged[mid] + (double)merged[mid-1]) / 2.0;
    	}else
    		return merged[mid];
    }
    
    
    
    
	public static void main(String[] args) {
		MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();
		int[] a = {1,3};
		int[] b = {};
		System.out.println(m.findMedianSortedArrays(a, b));
	}

}
