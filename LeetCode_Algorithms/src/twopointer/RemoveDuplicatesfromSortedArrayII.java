package twopointer;

/**
 * Given a sorted array nums, 
 * remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * @author Ryan
 *
 */
public class RemoveDuplicatesfromSortedArrayII {

	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;

		int i = 0;
		//counter of current number
		int c = 1;
		for (int j = 1; j < n; j++) {
			//if not equal, move n[j] to n[ni+1]
			//incre i set counter to 1
			if (nums[i] != nums[j]) {
				nums[i+1] = nums[j];
				i++;
				c = 1;
			} else {
				//if counter is less than 2, move n[j] to n[i+1]
				if (c < 2){
					nums[i+1] = nums[j];
					i++;
				}
				c++;
			}
		}
		return i+1;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII r = new RemoveDuplicatesfromSortedArrayII();
		int[] a = { 1, 1, 1, 2, 2, 3 };
		int[] b = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		//System.out.println(r.removeDuplicates(a));
		System.out.println(r.removeDuplicates(b));
	}

}
