package interview;

public class FillWith0 {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

    public static void setZeros(int[][][] matrix) {
	int[] row = new int[matrix.length];
	int[] column = new int[matrix[0].length];
	int[] depth = new int[matrix[0][0].length];
	// Store the row, column and depth index with value 0
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[0].length; j++) {
		for (int k = 0; k < matrix[0][0].length; k++) {
		    if (matrix[i][j][k] == 0) {
			row[i] = 1;
			column[j] = 1;
			depth[k] = 1;
		    }
		}
	    }
	}
	// Set matrix[i][j][k] to 0 if either row i, column j or depth k has a 0
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[0].length; j++) {
		for (int k = 0; k < matrix[0][0].length; k++) {
		    if (row[i] == 1 || column[j] == 1 || depth[k] == 1) {
			matrix[i][j][k] = 0;
		    }
		}
	    }
	}
    }

}
