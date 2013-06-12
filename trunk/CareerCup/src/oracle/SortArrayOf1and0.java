package oracle;

public class SortArrayOf1and0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = { 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };
		int N = arr.length;
		int sum = 0;
		int ndx;
		for (ndx = 0; ndx < N; ndx++)
			sum += arr[ndx];
		for (ndx = 0; ndx < N - sum; ndx++)
			arr[ndx] = 0;
		for (ndx = N - sum; ndx < N; ndx++)
			arr[ndx] = 1;

	}

}
