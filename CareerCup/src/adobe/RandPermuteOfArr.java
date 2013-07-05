package adobe;

public class RandPermuteOfArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = {};
		for (int i = 0; i < arr.length; i++) {
			int k = 0;// rand_n() - 1
			int temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}

	}

}
