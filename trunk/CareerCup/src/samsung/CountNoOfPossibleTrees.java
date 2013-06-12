package samsung;

/*
 * http://www.youtube.com/watch?v=UfA_v0VmiDg
 * http://en.wikipedia.org/wiki/Catalan_number
 */
public class CountNoOfPossibleTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(countNoOfPossibleTrees(3));
		//System.out.println(countNoOfPossibleTrees(4));
		//System.out.println(countNoOfPossibleTrees(5));
	}

	public static int countNoOfPossibleTrees(int n) {

		if (n == 0 || n == 1)
			return 1;
		else {
			int sum = 0, left = 0, right = 0;
			for (int k = 1; k <= n; k++) {
				left = countNoOfPossibleTrees(k - 1);
				right = countNoOfPossibleTrees(n - k);
				sum += left * right;
			}
			return sum;
		}
	}

}
