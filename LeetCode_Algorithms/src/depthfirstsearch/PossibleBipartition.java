package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 886. Possible Bipartition
 *
 */
public class PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colors = new int [N+1];
        List<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i <= N; i++) lists.add(new ArrayList<>());
        for(int[] dislike : dislikes) {
            lists.get(dislike[0]).add(dislike[1]);
            lists.get(dislike[1]).add(dislike[0]);
        }

        boolean res = true;
        for(int i=1; i<lists.size(); i++) {
            if(colors[i] == 0) {
                colors[i] = 1;
                if(!dfs(lists, colors, i))
                    return false;
            }
        }
        return res;
    }

    private boolean dfs(List<ArrayList<Integer>> lists, int[] colors, int i) {
        if(lists.get(i).size() == 0) return true;
        boolean res = true;
        for(int n : lists.get(i)) {
            if(colors[n] == 0) {
                colors[n] = colors[i] * -1;
                res = res & dfs(lists, colors, n);
            }
            else if(colors[n] == colors[i])
                return false;
        }
        return res;
    }


    public static void main (String[] args) {
        int[][] d = new int[][] {{1,2}, {1,3}, {2,4}};
        System.out.println(new PossibleBipartition().possibleBipartition(4, d));
    }

}
