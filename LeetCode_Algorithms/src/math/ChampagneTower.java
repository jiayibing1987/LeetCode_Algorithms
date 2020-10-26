package math;

public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0) return 0;
        double[][] matrix = new double[100][100];
        matrix[0][0] = poured;

        for(int i=0; i < 99; i++) {
            for(int j=0; j<=i; j++) {
                if(matrix[i][j] > 1) {
                    double overflow = matrix[i][j] - 1;
                    matrix[i+1][j] = overflow / 2;
                    matrix[i+1][j+1] = overflow / 2;
                }
            }
        }
        return matrix[query_row][query_glass];
    }

}
