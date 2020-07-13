package tree;

import util.TreeNode;

public class SameTree {

    boolean isSame = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, q);
        return isSame;
    }

    public void dfs(TreeNode p, TreeNode q) {
        if(p == null && q == null) return;
        if((p == null && q != null) || (p!= null && q == null)) {
            isSame = false;
            return;
        }
        if(p.val != q.val){
            isSame = false;
            return;
        }
        dfs(p.left, q.left);
        dfs(p.right, q.right);
    }


}
