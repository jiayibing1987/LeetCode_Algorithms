package thirtydayschallenge;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {

    List<List<Integer>> results;
    public List<List<Integer>> combinationSum3(int k, int n) {
        results = new ArrayList<>();
        if(k<=0 || n<=0) return results;
        backTrack(new ArrayList<>(), 0, k, 0, n, 1);
        return results;
    }

    private void backTrack(List<Integer>combination, int count, int k, int sum, int n, int start) {
        if(count > k) return;
        if(sum > n) return;
        if(count == k && sum == n) {
            results.add(combination);
            return;
        }

        for(int i=start; i<=9; i++) {
            List<Integer> temp = new ArrayList<>(combination);
            temp.add(i);
            backTrack(temp, count+1, k, sum+i, n, i+1);
        }
    }

    public static void main(String[] args) {
        CombinationSumThree c = new CombinationSumThree();
        System.out.println(c.combinationSum3(3 , 7));
    }
}
