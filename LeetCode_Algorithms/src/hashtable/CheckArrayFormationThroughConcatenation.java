package hashtable;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], i);
        }

        for(int[] piece : pieces) {
            if(!map.containsKey(piece[0])) {
                return false;
            } else {
                int index = map.get(piece[0]);
                for(int p : piece) {
                    if(index >= arr.length || p != arr[index])
                        return false;
                    index++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckArrayFormationThroughConcatenation c = new CheckArrayFormationThroughConcatenation();
        int[] arr = new int[] {91,4,64,78};
        int[][] p = new int[][] {{78}, {4,64}, {91}};
        System.out.println(c.canFormArray(arr, p));
    }
}
