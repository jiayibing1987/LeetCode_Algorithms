package sort;

import java.util.ArrayList;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] indices = new int[n];
        for(int i = 0; i < n; i++)
            indices[i] = i;
        mergeSort(nums, indices, count, 0, n-1);
        List<Integer> res = new ArrayList<>();
        for (int c : count)
            res.add(c);
        return res;
    }

    private void mergeSort(int[] nums, int[] indices, int[] count, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, indices, count, low, mid);
            mergeSort(nums, indices, count, mid + 1, high);
            merge(nums, indices, count, low, mid, high);
        }
    }

    //merge two sorted array
    private void merge(int[] nums, int[] indices, int[] count, int low, int mid, int high) {
        int left_len = mid - low + 1;
        int right_len = high - mid;

        int[] left = new int[left_len];
        int[] right = new int[right_len];
        
        for(int i = 0, j = low; i < left_len; i++, j++)
            left[i] = indices[j];
        for(int i = 0, j = mid + 1; i < right_len; i++, j++)
            right[i] = indices[j];
        
        int p1 = 0, p2 = 0, i = low, righ_count = 0;
        while(p1 < left_len && p2 < right_len) {
            if(nums[right[p2]] < nums[left[p1]]) {
                righ_count++;
                indices[i++] = right[p2++];
            } else {
                indices[i++] = left[p1];
                count[left[p1]] += righ_count;
                p1++;
            }
        }

        while(p1 < left_len) {
            indices[i++] = left[p1];
            count[left[p1]] += righ_count;
            p1++;
        }
        while(p2 < right_len) {
            indices[i++] = right[p2++];
        }
    }

    public static void main(String[] args) {
        CountofSmallerNumbersAfterSelf c = new CountofSmallerNumbersAfterSelf();
        System.out.println(c.countSmaller(new int[] {5,2,6,1}));
        System.out.println(c.countSmaller(new int[] {-1}));
        System.out.println(c.countSmaller(new int[] {-1, -1}));
    }

}
