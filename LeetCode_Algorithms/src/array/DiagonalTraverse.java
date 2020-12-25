package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {

    int count;
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        count = 0;

        for(int j=0; j<n; j++) {
            int i = 0;
            List<Integer> list = getOneDirectionList(matrix, i, j);
            res.addAll(list);
        }

        for(int i=1; i<m; i++) {
            int j = n-1;
            List<Integer> list = getOneDirectionList(matrix, i, j);
            res.addAll(list);
        }

        int[] array =  new int[res.size()];
        for(int i=0; i< res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;
    }

    private List<Integer> getOneDirectionList(int[][] matrix, int i, int j) {
        List<Integer> list = new ArrayList<>();
        while(i<matrix.length && j>=0) {
            list.add(matrix[i][j]);
            i++;
            j--;
        }
        if(count % 2 == 0)
            Collections.reverse(list);
        count ++;
        return list;
    }

}
