package accenture;

/*
 * http://www.youtube.com/watch?v=14Jb7aycv3c
 */
public class MakeValidEquation {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 1 };
		char[] res = new char[2 * arr.length - 1];
		int currentSum = arr[0];
		res[0] = (char) (arr[0] + '0');
		makeValidEquation(1, 1, currentSum, res, arr);
	}

	public static void makeValidEquation(int posArr, int posRes, int currentSum, char[] res, int[] arr) {

		if (posArr == arr.length - 1) {
			if (currentSum == arr[arr.length - 1]) {
				res[posRes++] = '=';
				res[posRes++] = (char) (arr[arr.length - 1] + '0');
				System.out.println(new String(res, 0, posRes));
			}

			return;
		}

		res[posRes] = '+';
		res[posRes + 1] = (char) (arr[posArr] + '0');
		makeValidEquation(posArr + 1, posRes + 2, currentSum + arr[posArr], res, arr);

		res[posRes] = '-';
		res[posRes + 1] = (char) (arr[posArr] + '0');
		makeValidEquation(posArr + 1, posRes + 2, currentSum - arr[posArr], res, arr);
	}

}
