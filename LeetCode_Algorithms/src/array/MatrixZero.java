package array;

public class MatrixZero {

    public void setZeroes(int[][] matrix) {
        int minusValue = -100000;
    	int row = matrix.length;
        int col = matrix[0].length;
    	for(int i=0; i<row; i++){
    		for(int j=0; j<col; j++){
    			if(matrix[i][j] == 0){
    				//set all non zero value to a negative value
    				for(int k=0; k<col; k++){
    					if(matrix[i][k] != 0)
    						matrix[i][k] = minusValue;
    				}
    				for(int l=0; l<row; l++){
    					if(matrix[l][j] != 0)
    						matrix[l][j] = minusValue;
    				}
    			}
    		}
    	}
    	
    	for(int i=0; i<row; i++){
    		for(int j=0; j<col; j++){
    			if(matrix[i][j] == minusValue)
    				matrix[i][j] = 0;
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
