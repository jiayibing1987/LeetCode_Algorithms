package contest;

public class MatrixCanBeObtainedByRotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        if(matrixEquals(mat, target))
            return true;

        rotateClockWise(mat);
        if(matrixEquals(mat, target))
            return true;

        rotateClockWise(mat);
        if(matrixEquals(mat, target))
            return true;

        rotateClockWise(mat);
        if(matrixEquals(mat, target))
            return true;

        return false;
    }

    public boolean matrixEquals(int[][] mat, int[][] target) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j ++) {
                if(mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }

    public void rotateClockWise(int[][] matrix) {
        int n = matrix[0].length;
        //swap ij to ji
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse each row
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
