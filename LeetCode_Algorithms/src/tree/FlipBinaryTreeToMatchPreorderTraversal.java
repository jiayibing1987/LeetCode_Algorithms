package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {

    boolean found = true;
    int index;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        index = 0;
        List<Integer> res = new ArrayList<>();
        preOrder(root, voyage, res);
        if(!found) return List.of(-1);
        return res;
    }


    private void preOrder(TreeNode root, int[] a, List<Integer> res) {
        if(root == null)
            return;
        if(index >= a.length)
            return;
        if(root.val != a[index]) {
            found = false;
            return;
        }

        index ++;
        TreeNode left = root.left;
        //need flip
        if(left != null && a[index] != left.val) {
            preOrder(root.right, a, res);
            preOrder(root.left, a, res);
            res.add(root.val);
        } else {
            preOrder(root.left, a, res);
            preOrder(root.right, a, res);
        }
    }

}
