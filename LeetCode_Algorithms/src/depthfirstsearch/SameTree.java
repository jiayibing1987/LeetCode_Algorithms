package depthfirstsearch;

import util.TreeNode;

/**
 * #100
 * Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value
 * @author Ryan
 *
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return helper(p, q, true);
	}

	private boolean helper(TreeNode p, TreeNode q, boolean isSame) {
		if (p == null && q == null) {
			return isSame;
		} else if (p == null && q != null) {
			return false;
		} else if (p != null && q == null) {
			return false;
		}

		if (p.val != q.val) {
			isSame = false;
			return isSame;
		}
		return helper(p.left, q.left, true) && helper(p.right, q.right, true);
	}

	public static void main(String[] args) {

	}
}
