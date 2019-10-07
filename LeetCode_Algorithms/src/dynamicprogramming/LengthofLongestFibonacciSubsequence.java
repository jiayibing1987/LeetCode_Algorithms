package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 873. Length of Longest Fibonacci Subsequence
 * @author Ryan
 *
 */
public class LengthofLongestFibonacciSubsequence {

	class Data{
		int pre;
		int cur;
		int length;
		
		public Data(int pre, int cur, int len){
			this.pre = pre;
			this.cur = cur;
			this.length = len;
		}
		
		public boolean equals(Object o){
			if(o instanceof Data) return false;
			Data d = (Data)o;
			return d.pre == this.pre;
		}
		
		public int hashCode(){
			return new Integer(pre).hashCode();
		}
		
		public String toString(){
			return "[" + pre + " " + cur + " " + length + "]";
		}
	}
	
    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, HashMap<Integer, Data>> map = new HashMap<Integer, HashMap<Integer,Data>>();
        for(int i=0; i<A.length; i++)
        	map.put(A[i], new HashMap<Integer, Data>());
        Data d = new Data(A[0], A[1], 2);
        HashMap<Integer, Data> mapForA1 = new HashMap<Integer,Data>();
        mapForA1.put(A[0], d);
        map.put(A[1], mapForA1);
        int res = 0;
        
        for(int i=1; i<A.length; i++){
    		Map<Integer, Data> dataMap = map.get(A[i]);
    		int cand = 0;
        	for(int j = i-1; j>=0; j--){
        		int pre;
        		int cur;
        		int length;
        		if(dataMap.containsKey(A[j])){
        			pre = dataMap.get(A[j]).pre;
        			cur = dataMap.get(A[j]).cur;
        			length = dataMap.get(A[j]).length;
        		}else{
        			pre = A[j];
        			cur = A[i];
        			length = 2;
        		}
    			if(map.containsKey(pre+cur)){
    				Data newData = new Data(cur, pre+cur, length+1);
    				map.get(pre+cur).put(cur, newData);
    			}
    			cand = Math.max(cand, length);
        	}
        	res = Math.max(cand, res);
        }
        return res <= 2 ? 0 : res;
    }
    
    
	public static void main(String[] args) {
		LengthofLongestFibonacciSubsequence l = new LengthofLongestFibonacciSubsequence();
		int[] a = {1,2,3,4,5,6,7,8};
		System.out.print(l.lenLongestFibSubseq(a));
	}

}
