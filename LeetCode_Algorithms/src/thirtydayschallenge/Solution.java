package thirtydayschallenge;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Random Pick with Weight
 *
 * Given an array w of positive integers, where w[i] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 */
public class Solution {

    TreeMap<Integer, Integer> map ;
    int sum ;
    public Solution(int[] w) {
        sum = 0;
        map = new TreeMap<>();
        for(int i=0; i<w.length; i++){
            sum += w[i];
            map.put(sum,i);
        }
    }

    public int pickIndex() {
        int ran = new Random().nextInt(sum)+1;
        int key = map.ceilingKey(ran);
        return map.get(key);
    }

    public static void main(String[] args) {
        int[] w = new int[] {1, 3};
        Solution obj = new Solution(w);
        int a1 = obj.pickIndex();
        int a2 = obj.pickIndex();
        int a3 = obj.pickIndex();
        int a4 = obj.pickIndex();
        int a5 = obj.pickIndex();

    }

}
