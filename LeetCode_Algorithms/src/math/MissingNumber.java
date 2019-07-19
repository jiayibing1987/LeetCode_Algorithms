package math;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected=0;
        for(int i=0; i<=n; i++)
        	expected += i; 
        int sum=0;
        for(int i=0; i<nums.length; i++){
        	sum += nums[i];
        }
        return expected - sum;
    }
    
	public static void main(String[] args) {
		MissingNumber m = new MissingNumber();
		int[] a = {3,0,1};
		int[] b = {9,6,4,2,3,5,7,0,1};
		System.out.println(m.missingNumber(a));
		System.out.println(m.missingNumber(b));
	}

}
