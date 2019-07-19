package tree;

/**
 * 307. Range Sum Query - Mutable, using array to store tree structure
 * @author Ryan
 *
 */
public class NumArray2 {

	int[] tree;
	int n;
    public NumArray2(int[] nums) {
    	n = nums.length;
    	tree = new int[n*4];
    	build(nums, 0, 0 , n-1);
    }
    
    private void build(int[] nums, int treeIndex, int low, int high){
    	if(low>high) return;
    	if(low == high){
    		tree[treeIndex] = nums[low];
    		return;
    	}
    	int mid = (low+high)/2;
    	build(nums, treeIndex*2+1, low, mid);//left half
    	build(nums, treeIndex*2+2, mid+1, high);
    	tree[treeIndex] = tree[treeIndex*2+1] + tree[treeIndex*2+2];
    }
    
    public void update(int i, int val) {
        updateHelper(0, 0, n-1, i, val);
    }
    
    private void updateHelper(int treeIndex, int low, int high, int i, int val){
    	if(low>high)
    		return;
    	//find leaf node, if index is same as node's range, update node
    	if(low== high ){
    		if(low == i) tree[treeIndex] = val;
    		return;
    	}
    	int mid = (low+high)/2;
    	updateHelper(treeIndex*2+1, low, mid, i, val);
    	updateHelper(treeIndex*2+2, mid+1, high, i, val);
    	tree[treeIndex] = tree[treeIndex*2+1] + tree[treeIndex*2+2];
    }
    
    public int sumRange(int i, int j) {
    	return sumRangeHelper(0, 0, n-1, i, j);
    }
    
    private int sumRangeHelper(int treeIndex, int low, int high, int i, int j){
    	if(low>high)
    		return 0;
    	if(low>= i && high <= j)//node is in range i to j
    		return tree[treeIndex];
    	else if(low>j || high<i) // node is completely out of range
    		return 0;
    	else{
    		int mid = (low+high)/2;
    		return sumRangeHelper(treeIndex*2+1, low, mid, i, j) + 
    				sumRangeHelper(treeIndex*2+2, mid+1, high, i, j);
    	}
    }
    
	public static void main(String[] args) {
		int[] a = {9,-8};
		NumArray2 n = new NumArray2(a);
		n.update(0, 3);

		System.out.println(n.sumRange(1, 1));
		System.out.println(n.sumRange(0, 1));

		n.update(1, -3);
		System.out.println(n.sumRange(0, 1));
	}

}
