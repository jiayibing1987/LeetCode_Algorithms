package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Pair {
	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}

	int a;
	int b;

	public String toString() {
		return a + " " + b;
	}
}

/**
 * Given a positive integer n, find the least number of perfect square numbers 
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * @author Ryan
 *
 */
public class PerfectSquares {
	List<Integer> list = new ArrayList<Integer>();;
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	// public int numSquares(int n) {
	// dfs(n, 0);
	// Collections.sort(list);
	// return list.get(0);
	// }
	//
	// private void dfs(int remain, int depth) {
	// if(map.containsKey(remain)){
	// if(map.get(remain) <= depth)
	// return;
	// }else{
	// map.put(remain, depth);
	// }
	// if (remain == 1){
	// list.add(depth + 1);
	// return;
	// }
	// if (remain == 0){
	// list.add(depth);
	// return;
	// }
	//
	// for(int i=(int) Math.sqrt(remain); i>=1; i--){
	// dfs(remain-(i*i), depth+1);
	// }
	// }

	// bfs
	// public int numSquares(int n) {
	// Queue<Pair> q = new LinkedList<Pair>();
	// q.add(new Pair(n, 1));
	//
	// while(!q.isEmpty()){
	// //System.out.println(q.peek());
	// if(q.peek().a == 1)
	// return q.peek().b;
	// for(int i=1; i*i<=q.peek().a; i++ ){
	// int remain = q.peek().a - i*i;
	// if(remain == 0)
	// return q.peek().b;
	// q.add(new Pair(q.peek().a - i*i, q.peek().b+1));
	// }
	// q.poll();
	// }
	// return 0;
	// }

	// dp solution
	// dp[n] = dp[j*j] + dp[n-j*j] which j from 1 to sqrt(n), also we know dp[j*j]=1
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		PerfectSquares p = new PerfectSquares();
		System.out.println(p.numSquares(12));
	}

}
