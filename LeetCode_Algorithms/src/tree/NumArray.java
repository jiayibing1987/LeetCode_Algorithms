package tree;

/**
 * 307. Range Sum Query - Mutable, tree structure
 * @author Ryan
 *
 */
public class NumArray {
	class SegmentTreeNode{
		int low, high;
		int val;
		SegmentTreeNode left;
		SegmentTreeNode right;
		
		public SegmentTreeNode(int l, int h){
			low = l;
			high = h;
		}
	}
	
	SegmentTreeNode root;
    public NumArray(int[] nums) {
    	root = build(nums, 0, nums.length-1);
    }
    
    private SegmentTreeNode build(int[] nums, int low, int high){
    	if(low>high) return null;
    	int mid = (low+high)/2;
    	SegmentTreeNode node = new SegmentTreeNode(low, high);
    	//a leaf node
    	if(low == high)
    		node.val = nums[low];
    	else{
    		node.left = build(nums, low, mid);
    		node.right = build(nums, mid+1, high);
    		node.val = node.left.val + node.right.val;
    	}
    	return node;
    }
    
    public void update(int i, int val) {
    	updateHelper(root, i, val);
    }
    
    private void updateHelper(SegmentTreeNode node, int i, int val){
    	if(node == null) return;
    	if(i<node.low || i>node.high) return;//index not in node's range then return
    	if(node.low == node.high && node.low ==i){ //update leaf node
    		node.val = val;
    		return ;
    	}
    	updateHelper(node.left, i, val);
    	updateHelper(node.right, i, val);
    	node.val = node.left.val + node.right.val;
    } 
    
    public int sumRange(int i, int j) {
    	return sumRangeHelper(root, i, j);
    }
    
    public int sumRangeHelper(SegmentTreeNode node, int i, int j){
    	if(node.low >= i && node.high<= j)
    		return node.val;
    	else if(node.low > j || node.high < i){
    		return 0;
    	}else{
    		return sumRangeHelper(node.left, i, j) +
    				sumRangeHelper(node.right, i, j);
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
