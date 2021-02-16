package sort;

import java.util.PriorityQueue;

public class TheKWeakestRowsinaMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++) {
            int count = getCount(mat[i]);
            Row row = new Row(i, count);
            pq.add(row);
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll().index;
        }
        return res;
    }

    private int getCount (int[] array) {
        int count = 0;
        for(int a : array) {
            if(a == 1) count ++;
        }
        return count;
    }

    class Row implements Comparable<Row>{
        int index;
        int soldiers;

        public Row(int index, int soldiers) {
            this.index = index;
            this.soldiers = soldiers;
        }

        public int compareTo (Row row) {
            if(row.soldiers == this.soldiers) {
                return Integer.compare(this.index, row.index);
            }
            return Integer.compare(this.soldiers, row.soldiers);
        }
    }
}
