package tree;

import util.TreeNode;

/**
 * 617. Merge Two Binary Trees
 *
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode mergedTree = helper(t1, t2);
        return mergedTree;
    }

    public TreeNode helper(TreeNode t1, TreeNode t2) {
        return null;
    }



}
