package binarysearch;

public class MedianofTwoSortedArrays {

    //(log m + n) binary search
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int v1;
        int median_index = (m + n) / 2;
        v1 = findKlargestNumber(nums1, 0, m - 1, nums2, 0, n - 1, median_index + 1);
        if ((m + n) % 2 != 0) {
            return v1;
        }
        int v2 = findKlargestNumber(nums1, 0, m - 1, nums2, 0, n - 1, median_index);
        return (v1 + v2) / 2.0d;
    }

    private int findKlargestNumber(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
    	if(l1 > r1) {
    		return nums2[l2 + k - 1];
		} else if (l2 > r2) {
			return nums1[l1 + k - 1];
		}

        int m1 = l1 + (r1 - l1) / 2;
        int m2 = l2 + (r2 - l2) / 2;

        if (nums1[m1] < nums2[m2]) {
            if ((m1 - l1 + 1) + (m2 - l2 + 1) > k) {
                return findKlargestNumber(nums1, l1, r1, nums2, l2, m2 - 1, k);
            } else {
                return findKlargestNumber(nums1, m1 + 1, r1, nums2, l2, r2, k - (m1 - l1 + 1));
            }
        } else {
			if ((m1 - l1 + 1) + (m2 - l2 + 1) > k) {
				return findKlargestNumber(nums1, l1, m1 - 1, nums2, l2, r2, k);
			} else {
				return findKlargestNumber(nums1, l1, r1, nums2, m2 + 1, r2, k - (m2 - l2 + 1));
			}
        }
    }

    //O(m+n)
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        int p1 = 0, p2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (p1 < m && p2 < n) {
                if (nums1[p1] < nums2[p2])
                    merged[i] = nums1[p1++];
                else
                    merged[i] = nums2[p2++];
            } else if (p1 >= m) {
                merged[i] = nums2[p2++];
            } else if (p2 >= n) {
                merged[i] = nums1[p1++];
            }
        }
        int mid = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return ((double) merged[mid] + (double) merged[mid - 1]) / 2.0;
        } else
            return merged[mid];
    }


    public static void main(String[] args) {
        MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();
/*        int[] a = {1, 2};
        int[] b = {3, 4};
        System.out.println(m.findMedianSortedArrays(a, b));*/


		int[] a = {0,0,0,0,0};
		int[] b = {-1,0,0,0,0,0,1};
		System.out.println(m.findMedianSortedArrays(a, b));
    }

}
