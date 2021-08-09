package greedy;

import java.util.*;

public class RankTransformofaMatrix {

    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] res = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                pq.add(new int[] {i , j, matrix[i][j]});
            }
        }

        List<int[]>[] rows_rank = new List[m];
        Map<Integer, RankNode>[] rows_map = new HashMap[m];
        for(int i = 0; i < m; i++) {
            rows_rank[i] = new ArrayList<>();
            rows_map[i] = new HashMap<>();
        }

        List<int[]>[] cols_rank = new List[n];
        Map<Integer, RankNode>[] cols_map = new HashMap[n];
        for(int j = 0; j < n; j++) {
            cols_rank[j] = new ArrayList<>();
            cols_map[j] = new HashMap<>();
        }

        RankNode[][] rankMatrix = new RankNode[m][n];
        initRankNodeMatrix(rankMatrix , matrix);
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];

            int[] last_row_ele = rows_rank[i].isEmpty() ? null : rows_rank[i].get(rows_rank[i].size() - 1);
            int[] last_col_ele = cols_rank[j].isEmpty() ? null : cols_rank[j].get(cols_rank[j].size() - 1);
            int excpected_row_rank = getRank(last_row_ele, cur, rows_map[i]);
            int excpected_col_rank = getRank(last_col_ele, cur, cols_map[j]);
            int cur_rank = Math.max(excpected_row_rank, excpected_col_rank);

            rows_rank[i].add(cur);
            cols_rank[j].add(cur);
            if(rows_map[i]. containsKey(cur[2])) {
                rows_map[i].put(cur[2], new RankNode(cur_rank));
            } else {
                rows_map[i].get(cur[2]).rank = cur_rank;
            }

            if(cols_map[i]. containsKey(cur[2])) {
                cols_map[i].put(cur[2], new RankNode(cur_rank));
            } else {
                cols_map[i].get(cur[2]).rank = cur_rank;
            }
            //rows_map[i].put(cur[2], cur_rank);
            //cols_map[j].put(cur[2], cur_rank);
        }

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                res[i][j] = rows_map[i].get(matrix[i][j]).rank;
            }
        }
        return res;
    }

    private void initRankNodeMatrix(RankNode[][] rankMatrix, int[][] matrix) {

    }

    private int getRank(int[] node, int[] cur, Map<Integer, RankNode> map) {
        if(node == null) {
            return 1;
        }
        if(node[2] == cur[2]) {
            return map.get(node[2]).rank;
        }
        return map.get(node[2]).rank + 1;
    }

    class RankNode {
        int rank;
        public RankNode(int r) {
            rank = r;
        }
    }

    public static void main(String[] args) {
        RankTransformofaMatrix r = new RankTransformofaMatrix();
        int[][] m1 = new int[][] {{1, 2}, {3, 4}};
        //System.out.println(Arrays.toString(r.matrixRankTransform(m1)));

        int[][] m2 = new int[][] {
                {-23,20,-49,-30,-39,-28,-5,-14},
                {-19,4,-33,2,-47,28,43,-6},
                {-47,36,-49,6,17,-8,-21,-30},
                {-27,44,27,10,21,-8,3,14},
                {-19,12,-25,34,-27,-48,-37,14},
                {-47,40,23,46,-39,48,-41,18},
                {-27,-4,7,-10,9,36,43,2},
                {37,44,43,-38,29,-44,19,38}};
        System.out.println(Arrays.toString(r.matrixRankTransform(m2)));
    }
}
