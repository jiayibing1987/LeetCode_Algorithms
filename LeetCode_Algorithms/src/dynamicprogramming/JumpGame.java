package dynamicprogramming;

public class JumpGame {

//	//1.back track
//	public boolean canJump(int[] nums) {
//		return backtrack(0, nums);
//	}
//
//	private boolean backtrack(int pos, int[] a) {
//		if (pos == a.length - 1)
//			return true;
//		int steps = a[pos];
//		for (int nextPos = pos+1; nextPos <= pos + steps; nextPos++) {
//			boolean found = backtrack(nextPos, a);
//			if(found == true) return true;
//		}
//		return false;
//	}
	
	enum Index{
		GOOD,
		BAD,
		UNKNOWN
	}
	Index[] memo;
	//2dp top down
//	
//	public boolean canJump(int[] nums) {
//		memo = new Index[nums.length];
//		for(int i=0; i<nums.length; i++){
//			memo[i] = Index.UNKNOWN;
//		}
//		memo[nums.length-1] = Index.GOOD;
//		return topDown(nums, 0);
//	}
//	
//	private boolean topDown(int[] a, int pos){
//		if(memo[pos] != Index.UNKNOWN)
//			return memo[pos] == Index.GOOD? true : false;
//		int steps = a[pos];
//		for(int nextPos = pos+1; nextPos<=pos+steps; nextPos++){
//			boolean found = topDown(a, nextPos);
//			if(found == true){
//				memo[pos] = Index.GOOD;
//				return true;
//			}
//		}
//		memo[pos] = Index.BAD;
//		return false;
//	}
	
	//3. bottom up
//	public boolean canJump(int[] nums) {
//		memo = new Index[nums.length];
//		for(int i=0; i<nums.length; i++){
//			memo[i] = Index.UNKNOWN;
//		}
//		memo[nums.length-1] = Index.GOOD;
//		
//		l:for(int pos=nums.length-2; pos>=0; pos--){
//			int steps = nums[pos];
//			for(int nextPos=pos+1; nextPos<=pos+steps; nextPos++){
//				if(memo[nextPos] == Index.GOOD){
//					memo[pos] = Index.GOOD;
//					continue l;
//				}
//			}
//			memo[pos] = Index.BAD;
//		}
//		return memo[0] == Index.GOOD;
//	}
	
	//4. greedy
	public boolean canJump(int[] nums) {
		int leftMostPos = nums.length-1;
		for(int pos=nums.length-2; pos>=0; pos--){
			int steps = nums[pos];
			if(pos+steps >= leftMostPos){
				leftMostPos = pos;
			}
		}
		return leftMostPos == 0;
	}
	

	public static void main(String[] args) {
		JumpGame j = new JumpGame();
		int[] a = { 2, 3, 1, 1, 4 };
		int[] b = {3,2,1,0,4};
		System.out.println(j.canJump(a));
		//System.out.println(j.canJump(b));

	}

}
