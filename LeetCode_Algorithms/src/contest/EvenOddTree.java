package contest;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 0;

        while(q.isEmpty()) {
            int size = q.size();
            TreeNode pre = null;
            for(int i=0; i<size; i++) {
                TreeNode cur = q.poll();
                if(level % 2 == 0) {
                    //check if odd integer values in strictly increasing order
                    if(cur.val % 2 == 0)
                        return false;
                    if(i >0 && cur.val <= pre.val)
                        return false;
                }else {
                    //check if  even integer values in strictly decreasing order
                    if(cur.val % 2 == 1)
                        return false;
                    if(i >0 && cur.val >= pre.val)
                        return false;
                }
                pre = cur;
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            level++;
        }
        return true;
    }
}
