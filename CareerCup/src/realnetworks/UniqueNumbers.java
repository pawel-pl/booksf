package realnetworks;

public class UniqueNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 7, 8 };

		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.println(arr[i]);
				break;
			}
			if (arr[i] != arr[i + 1]) {
				System.out.println(arr[i]);
			} else {
				while (arr[i] == arr[i + 1]) {
					i++;
				}
			}
		}
	}

}
