package riverbed;

public class MergeNSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void mergedArray(int[][] a) {
	    
		int m = a.length;
	    int n = a[0].length;
	    int[] indices = new int[m]; //java initializes the elements to 0s
	    int[] big = new int[m*n];
	    for(int i = 0; i < big.length; i++) {
	        // Lets find the minimum element
	        int min = Integer.MAX_VALUE;
	        int minArrayIndex = -1;
	        for(int j = 0; j < m; j++) {
	            if(indices[j] >= n) continue;
	            if(min < a[j][indices[j]]) {
	                min = a[j][indices[j]];
	                minArrayIndex = j;
	            } 
	        }
	        big[i] = min;
	        indices[minArrayIndex]++;
	    }
	}
}
