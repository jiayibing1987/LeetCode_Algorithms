package dynamicprogramming;

/**
 * 
 * #198 House Robber
 *
 */
public class RobHouse {

//	public int rob(int[] num) {
//		int rob = 0;
//		int notRob = 0;
//		for(int n: num){
//			int temp = notRob;
//			notRob = Math.max(notRob, rob);
//			rob = temp + n;
//		}
//				
//		return Math.max(rob, notRob);
//	}
	
	
	public int rob(int[] nums){
		if(nums.length == 0)
			return 0;

		int[] rob = new int[nums.length+1];
		rob[0] = 0;
		rob[1] = nums[0];
		
		for(int i=1; i<nums.length; i++){
			rob[i+1] = Math.max(rob[i], rob[i-1]+nums[i]);
		}
		return rob[nums.length];
	}
	
	public static void main(String[] args) {
		RobHouse r = new RobHouse();
		int[] a = {1,2,3,1};
		int[] b = {2,7,9,3,1};
		int[] c = {2,1,1,2};
		
		System.out.println(r.rob(a));
		System.out.println(r.rob(b));
	}

}
  