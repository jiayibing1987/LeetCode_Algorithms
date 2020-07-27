package thirtydayschallenge;

import util.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int end = inorder.length - 1;
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++)
            map.put(inorder[i], i);

        return build(inorder, postorder, 0, end, 0, end);
    }

    public TreeNode build(int[] inorder, int[] postorder, int startIn, int endIn, int startPost, int endPost) {
        if(startIn > endIn || startPost > endPost ) return null;
        if(startIn == endIn) return new TreeNode(inorder[startIn]);

        int rootIndex = map.get(postorder[endPost]);
        TreeNode node = new TreeNode(inorder[rootIndex]);

        int offset = rootIndex - startIn;
        node.left = build(inorder, postorder, startIn, rootIndex-1, startPost, startPost+offset-1);
        node.right = build(inorder, postorder,rootIndex+1, endIn,startPost+offset, endPost-1);
        return node;
    }

    public static void main(String[] args) {
        int[] in =   {9, 3, 15, 20, 7};
        int[] post = {9, 15, 7, 20, 3};
        ConstructBinaryTreefromInorderandPostorderTraversal c = new ConstructBinaryTreefromInorderandPostorderTraversal();
        System.out.println(c.buildTree(in, post));
    }

}
