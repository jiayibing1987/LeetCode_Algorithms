package thirtydayschallenge;



public class LeftmostColumnwithatLeastaOne {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        int i = 0;
        int j = n-1;
        int res = n;
        while(i <= m-1 && j >= 0){
            if(binaryMatrix.get(i, j) == 1) {
                res = Math.min(res, j);
                j--;
            }
            else { // maxtrix[i][j] == 0
                i++;
            }
        }
        return res == n ? -1 : res;
    }
}
