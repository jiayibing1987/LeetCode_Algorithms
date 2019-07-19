package tree;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;
/*#662
 * @author Ryan
 *
 */
public class MaximumWidthofBinaryTree {

	public int widthOfBinaryTree(TreeNode root) {
		Queue<NodeWithPosition> queue = new LinkedList<NodeWithPosition>();
		queue.add(new NodeWithPosition(root, 0, 0));
		int max = 0;
		int currentDepth = 0;
		int left = 0;
		while (!queue.isEmpty()) {
			NodeWithPosition node = queue.poll();
			if (node.treeNode != null) {
				queue.add(new NodeWithPosition(node.treeNode.left, node.depth + 1, node.pos * 2));
				queue.add(new NodeWithPosition(node.treeNode.right, node.depth + 1, node.pos * 2 + 1));

				if (currentDepth != node.depth) {
					currentDepth = node.depth;
					left = node.pos;
				}
				max = Math.max(max, node.pos - left + 1);
			}
		}
		return max;
	}

	class NodeWithPosition {
		TreeNode treeNode;
		int depth;
		int pos;

		public NodeWithPosition(TreeNode treeNode, int depth, int pos) {
			this.treeNode = treeNode;
			this.depth = depth;
			this.pos = pos;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
