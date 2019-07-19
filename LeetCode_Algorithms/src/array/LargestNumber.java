package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * @author Ryan
 *
 */
public class LargestNumber {

	public String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for(int i=0; i<nums.length; i++){
			strs[i] = String.valueOf(nums[i]);
		}
		//sort strings array
		Arrays.sort(strs, new Comparator<String>(){		
			@Override
			public int compare(String s1, String s2) {
				String str1 = s1 + s2;
				String str2 = s2 + s1;
				return str1.compareTo(str2);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=nums.length-1; i>=0; i--){
			sb.append(strs[i]);
		}
		return sb.toString().replaceFirst("^0+(?!$)", "");
	}
	
	/*
	public String largestNumber(int[] nums) {
		String result = "";
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length - i; j++) {
				if (isGreaterThan(nums[j - 1], nums[j])) {
					int temp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = temp;
				}
			}
			result = result + nums[nums.length - i - 1];
		}
		return result.replaceFirst("^0+(?!$)", "");
	}
*/
	public boolean isGreaterThan(int n1, int n2) {
		String s1 = String.valueOf(n1);
		String s2 = String.valueOf(n2);
		if(Long.parseLong(s1+s2) > Long.parseLong(s2+s1)){
			return true;
		}else
			return false;		
	}

	public static void main(String[] args) {
		LargestNumber l = new LargestNumber();
		int[] a = { 3, 30, 34, 5, 9 };
		System.out.println(l.largestNumber(a));
		int[] b = {12,121};
		System.out.println(l.largestNumber(b));
		int[] c = {0, 0};
		System.out.println(l.largestNumber(c));
	}

}
