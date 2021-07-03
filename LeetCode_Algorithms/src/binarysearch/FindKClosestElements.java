package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (k == arr.length) return Arrays.stream(arr).boxed().collect(Collectors.toList());
        int closestIndex = find(arr, x);
        if(k == 1) {
            int closestNum = arr[closestIndex];
            return List.of(closestNum);
        }
        int start = findStart(arr, k, x, Math.max(0, closestIndex - k), Math.min(closestIndex, arr.length - k));
        for (int i = start; i < start + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public int find (int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            int midValue = arr[mid];
            if(midValue < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if(low == arr.length || (low > 0 && Math.abs(arr[low-1] - x) <= Math.abs(arr[low] - x)))
            return low - 1;
        return low;
    }

    private int findStart(int[] arr, int k, int x, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            int start = mid;
            int end = mid + k - 1;
            boolean l = start > 0 && Math.abs(arr[start - 1] - x) < Math.abs(arr[end] - x);
            boolean r = end < arr.length - 1 && Math.abs(arr[end + 1] - x) < Math.abs(arr[start] - x);
            if (!l && !r) {
                if (start > 0 && Math.abs(arr[start - 1] - x) == Math.abs(arr[end] - x)) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else if (l && !r) high = mid - 1;
            else if (!l && r) low = mid + 1;
            else if (l && r) high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        FindKClosestElements f = new FindKClosestElements();

        int[] arr0 = new int[]{1,2,3,4,5};
        System.out.println(f.findClosestElements(arr0, 4, 3));

        int[] arr1 = new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        System.out.println(f.findClosestElements(arr1, 3, 5));

        int[] arr2 = new int[]{1, 1, 1, 10, 10, 10};
        System.out.println(f.findClosestElements(arr2, 1, 9));

        int[] arr3 = new int[]{1,1,2,2,2,2,2,3,3};
        System.out.println(f.findClosestElements(arr3, 3, 3));
        //System.out.println(f.find(arr3, 2));

        System.out.println(f.findClosestElements(new int[] {0,1,1,1,2,3,6,7,8,9}, 9, 4));
        System.out.println(f.findClosestElements(new int[] {1, 3}, 1, 2));

    }

}
