package contest;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumOperationstoReduceXtoZero {

    public int minOperations(int[] nums, int x) {
        int count = 0;
        int n = nums.length;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, n-1, x));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0; k<size; k++) {
                Node node = q.poll();
                int i = node.i;
                int j = node.j;
                if(node.value == 0) return count;
                if(node.i > node.j) continue;

                //two moves i+1 or j-1;
                if(node.value - nums[i] >= 0 ) {
                    q.add(new Node(i+1, j, node.value - nums[i]));
                }
                if(node.value - nums[j] >=0) {
                    q.add(new Node(i, j-1, node.value - nums[j]));
                }
            }
            count ++;
        }

        return -1;
    }

    public class Node {
        int i;
        int j;
        int value;

        public Node (int i, int j, int v) {
            this.i = i;
            this.j = j;
            this.value = v;
        }
    }

    public static void main(String[] args) {
        MinimumOperationstoReduceXtoZero m = new MinimumOperationstoReduceXtoZero();
        int x = 10;
        int[] a = {3,2,20,1,1,3};
        System.out.print(m.minOperations(a, x));
    }
}
