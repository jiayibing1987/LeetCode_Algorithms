package backtrack;

//similar as #46 permutation
public class BeautifulArrangement {

    int count;
    public int countArrangement(int n) {
        count = 0;
        boolean[] used = new boolean[n+1];
        backTrack(n, 1, used);
        return count;
    }

    private void backTrack (int n, int index, boolean[] used) {
        if(index > n) {
            count ++;
            return;
        }

        for(int i=1; i<=n; i++) {
            if(used[i] ) continue;
            used[i] = true;
            //only go deeper if condition check passed, to avoid redundant permutation
            if(conditionsCheck(i, index))
                backTrack(n, index+1, used);
            used[i] = false;
        }
    }

    private boolean conditionsCheck (int num, int i) {
        return num % i == 0 || i % num == 0;
    }

}
