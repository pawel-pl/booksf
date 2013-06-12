package linkedin;

/*
 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
 * http://www.geeksforgeeks.org/majority-element/
 */
public class MajorElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// int[] arr = { 1, 1, 1, 3, 3, 2, 2, 3, 3, 3, 2, 3, 3 };
		// int[] arr = { 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 2, 2, 2 };
		int[] arr = { 2, 2, 2, 3, 3, 3, 1 };
		int candidate = findCandidate(arr);
		System.out.println("Candidate: " + candidate + ", " + checkCandidate(candidate, arr));

	}

	public static int findCandidate(int[] arr) {

		int count = 1;
		int candidate = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (count == 0) {
				count++;
				candidate = arr[i];
			} else if (candidate == arr[i]) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}

	public static boolean checkCandidate(int candidate, int[] arr) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == candidate) {
				if (++count > arr.length / 2) {
					return true;
				}
			}
		}
		return false;
	}

}
