package twitter;

public class PrintCountNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 1, 1, 2, 3, 4, 4 };

		int current = arr[0];
		int count = 1;

		for (int i = 1; i < arr.length; i++) {
		    	if (arr[i] == current) {
				count++;
				continue;
			}
		    	System.out.println(current + " - " + count);
			current = arr[i];
			count = 1;
		}
		
		System.out.println(current + " - " + count);
	}

}
