package thirtydayschallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    String[] outputs;
    Set<Integer> columns = new HashSet<>();
    Set<Integer> d1 = new HashSet<>();
    Set<Integer> d2 = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        columns = new HashSet<>();
        d1 = new HashSet<>();
        d2 = new HashSet<>();
        outputs = new String[n];

        preBuild(n);
        backTrack(n, 0, new ArrayList<>(), res);
        return res;
    }

    private void preBuild(int n) {
        for(int i = 0; i < n; i ++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j ++) {
                if(i == j)
                    sb.append("Q");
                else
                    sb.append(".");
            }
            outputs[i] = sb.toString();
        }
    }

    private void backTrack(int n, int row, List<String> temp, List<List<String>> res) {
        if(row == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int col = 0; col < n; col++) {
            if(validate(row, col)) {
                //update cols, and two diagonals and temp result
                columns.add(col);
                d1.add(row - col);
                d2.add(row + col);
                temp.add(outputs[col]);
                backTrack(n, row + 1, temp, res);
                columns.remove(col);
                d1.remove(row - col);
                d2.remove(row + col);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean validate (int row, int col) {
        if(columns.contains(col))
            return false;
        if(d1.contains(row - col))
            return false;
        if(d2.contains(row + col))
            return false;

        return true;
    }

    public static void main(String[] args) {
        NQueens q = new NQueens();
        System.out.println(q.solveNQueens(4));
    }
}
