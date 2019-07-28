package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * #133. Clone Graph
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. 
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * @author Ryan
 *
 */
public class CloneGraph {

	public Node cloneGraph(Node node) {
		if(node == null) return null;

		//a map to store visited node
		Map<Node, Node> map = new HashMap<Node, Node>();
		Node newRoot = new Node(node.val, new ArrayList<Node>());
        map.put(node, newRoot);
		
		Queue<Node> q = new LinkedList<Node>();
        q.add(node);

        while(!q.isEmpty()){
        	Node originalNode = q.poll();
        	Node cloneNode = map.get(originalNode); 
        	//build connections with neighbors
        	for(Node neighbor : originalNode.neighbors){
        		Node cloneNeighbor = null;
        		if(map.containsKey(neighbor)){
        			cloneNeighbor = map.get(neighbor);
        		}else{
        			cloneNeighbor = new Node(neighbor.val, new ArrayList<Node>());
        			map.put(neighbor, cloneNeighbor);
        			q.add(neighbor);
        		}
    			cloneNode.neighbors.add(cloneNeighbor);
        	}
        }
        return newRoot;
	}

	// Definition for a Node.
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
		}

		public Node(int _val, List<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
