package dynamicprogramming;

public class HouseRobberTwo {

    public int rob(int[] nums) {
    	int n = nums.length;
    	if(n == 1) return nums[0];
    	int[] startFirst = new int[n];
    	int[] startSecond = new int[n+1];
    	
    	startFirst[0] = 0;
    	startFirst[1] = nums[0];
    	startSecond[0] = 0;
    	startSecond[1] = 0;
    	startSecond[2] = nums[1];
    	
    	for(int i=1; i<n-1; i++){
    		startFirst[i+1] = Math.max(startFirst[i], startFirst[i-1]+nums[i]);
    	}
    	for(int i=2; i<n; i++){
    		startSecond[i+1] = Math.max(startSecond[i], startSecond[i-1] + nums[i]);
    	}
    	
    	return Math.max(startFirst[n-1], startSecond[n]);
    }
    
	public static void main(String[] args) {
		HouseRobberTwo h = new HouseRobberTwo();
		int[] a = {2,3,2};
		int[] b = {1,2,3,1};
		System.out.println(h.rob(a));
		System.out.println(h.rob(b));

	}

}
