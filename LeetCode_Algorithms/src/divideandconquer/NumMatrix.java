package divideandconquer;

public class NumMatrix {

    int m;
    int n;
    SegmentTreeNode root;
    public NumMatrix(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        root = build(0, 0, m - 1, n - 1, matrix);
    }

    private SegmentTreeNode build(int row1, int col1, int row2, int col2, int[][] matrix) {
        if (row1 > row2 || col1 > col2)
            return null;
        if (row1 == row2 && col1 == col2)
            return new SegmentTreeNode(row1, col1, row2, col2, matrix[row1][col1]);

        int rowMid = (row1 + row2) / 2;
        int colMid = (col1 + col2) / 2;

        SegmentTreeNode node = new SegmentTreeNode(row1, col1, row2, col2, 0);
        node.c1 = build(row1, col1, rowMid, colMid, matrix);
        node.c2 = build(row1, colMid + 1, rowMid, col2, matrix);
        node.c3 = build(rowMid + 1, col1, row2, colMid, matrix);
        node.c4 = build(rowMid + 1, colMid + 1, row2, col2, matrix);

        node.val += node.c1 != null ? node.c1.val : 0;
        node.val += node.c2 != null ? node.c2.val : 0;
        node.val += node.c3 != null ? node.c3.val : 0;
        node.val += node.c4 != null ? node.c4.val : 0;
        return node;
    }

    public void update(int row, int col, int val) {
        updateHelper(row, col, val, root);
    }

    private void updateHelper(int row, int col, int val, SegmentTreeNode node) {
        if(node == null)
            return;
        if(row < node.row1 || row > node.row2 ||col < node.col1 ||col > node.col2 )
            return;

        if(row == node.row1 && row == node.row2 && col == node.col1 && col == node.col2) {
            node.val = val;
            return;
        }

        updateHelper(row, col, val, node.c1);
        updateHelper(row, col, val, node.c2);
        updateHelper(row, col, val, node.c3);
        updateHelper(row, col, val, node.c4);

        node.val = 0;
        node.val += node.c1 != null ? node.c1.val : 0;
        node.val += node.c2 != null ? node.c2.val : 0;
        node.val += node.c3 != null ? node.c3.val : 0;
        node.val += node.c4 != null ? node.c4.val : 0;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumHelper(row1, col1, row2, col2, root);
    }

    public int sumHelper(int row1, int col1, int row2, int col2, SegmentTreeNode node) {
        if(node == null)
            return 0;
        if(row2 < node.row1 || row1 > node.row2 ||col2 < node.col1 ||col1 > node.col2 )
            return 0;
        if(node.row1 >= row1  && node.col1 >= col1  && node.row2 <= row2 && node.col2 <= col2) {
            return node.val;
        }

        int v1 = sumHelper(row1, col1, row2, col2, node.c1);
        int v2 = sumHelper(row1, col1, row2, col2, node.c2);
        int v3 = sumHelper(row1, col1, row2, col2, node.c3);
        int v4 = sumHelper(row1, col1, row2, col2, node.c4);
        return v1 + v2 + v3 + v4;
    }

    class SegmentTreeNode {
        int row1;
        int col1;
        int row2;
        int col2;
        int val;

        SegmentTreeNode c1, c2, c3, c4;

        public SegmentTreeNode(int r1, int c1, int r2, int c2, int v) {
            row1 = r1;
            col1 = c1;
            row2 = r2;
            col2 = c2;
            this.val = v;
        }
    }

    public static void main(String[] args) {
/*        int[][] matrix1 = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix n  = new NumMatrix(matrix1);
        System.out.println(n.sumRegion(2,1,4,3));
        n.update(3,2,2);
        System.out.println(n.sumRegion(2,1,4,3));*/

        int[][] matrix2 = {{1,2}};
        NumMatrix n2  = new NumMatrix(matrix2);
        System.out.println(n2.sumRegion(0,0,0,0));
        System.out.println(n2.sumRegion(0,1,0,1));
        System.out.println(n2.sumRegion(0,0,0,1));
        n2.update(0,0,3);
        n2.update(0,1,5);
        System.out.println(n2.sumRegion(0,0,0,1));
    }
}
