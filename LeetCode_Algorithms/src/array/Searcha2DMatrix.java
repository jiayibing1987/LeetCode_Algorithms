package array;

public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        Coordinate tl = new Coordinate(0 ,0);
        Coordinate tr = new Coordinate(0 ,n-1);
        Coordinate bl = new Coordinate(m-1, 0);
        Coordinate br = new Coordinate(m-1, n-1);

        while(tl.i <= br.i && tl.j <= br.j ) {
            if(matrix[tl.i][tl.j] == target
                    || matrix[tr.i][tr.j] == target
                    || matrix[bl.i][bl.j] == target
                    || matrix[br.i][br.j] == target)
                return true;

            if(!isInRange(matrix, target, tl, tr)) {
                tl.i++;
                tr.i++;
            } else if (!isInRange(matrix, target, bl, br)) {
                bl.i--;
                br.i--;
            } else if (!isInRange(matrix, target, tl, bl)) {
                tl.j++;
                bl.j++;
            } else if (!isInRange(matrix, target, tr, br)) {
                tr.j--;
                br.j--;
            } else {
                System.out.print("err");
            }
        }
        return matrix[tl.i][tl.j] == target;
    }

    private boolean isInRange(int[][] matrix, int target, Coordinate c1, Coordinate c2) {
        return target >= matrix[c1.i][c1.j] && target <= matrix[c2.i][c2.j];
    }

    public class Coordinate {
        int i;
        int j;

        public Coordinate (int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}
