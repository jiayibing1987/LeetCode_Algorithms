package tree;

import util.TreeNode;

/**
 * #108
 * @author Ryan
 *
 */
public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }
    
    private TreeNode buildBST(int[] nums, int low, int high){
    	if(low>high) return null;
    	int mid = (low+high)/2;
    	TreeNode node = new TreeNode(nums[mid]);
    	node.left = buildBST(nums, low, mid-1);
    	node.right = buildBST(nums, mid+1, high);
    	return node;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
