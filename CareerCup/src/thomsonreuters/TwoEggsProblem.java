package thomsonreuters;

import java.util.Arrays;

/*
 * http://www.programmerinterview.com/index.php/puzzles/2-eggs-100-floors-puzzle/
 * http://www.datagenetics.com/blog/july22012/index.html n*(n+1)/2  >=  100
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 */
public class TwoEggsProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(eggDropDP(3, 10));
	}

	/*
	 * Since we need to minimize the number of trials in worst case - > max is wc , we take the maximum of two cases
	 */
	public static int eggDrop(int n, int k) {
		// If there are no floors, then no trials needed. OR if there is
		// one floor, one trial needed.
		if (k == 1 || k == 0)
			return k;

		// We need k trials for one egg and k floors
		if (n == 1)
			return k;

		int min = Integer.MAX_VALUE, x, res;

		// Consider all droppings from 1st floor to kth floor and
		// return the minimum of these values plus 1.
		for (x = 1; x <= k; x++) {
			res = Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));
			if (res < min)
				min = res;
		}

		return min + 1;
	}

	public static int eggDropDP(int n, int k) {
		/*
		 * A 2D table where entery eggFloor[i][j] will represent minimum number
		 * of trials needed for i eggs and j floors.
		 */
		int[][] eggFloor = new int[n + 1][k + 1];
		int res;
		int i, j, x;

		// We need one trial for one floor and0 trials for 0 floors
		for (i = 1; i <= n; i++) {
			eggFloor[i][1] = 1;
			eggFloor[i][0] = 0;
		}

		// We always need j trials for one egg and j floors.
		for (j = 1; j <= k; j++)
			eggFloor[1][j] = j;

		// Fill rest of the entries in table using optimal substructure
		// property
		for (i = 2; i <= n; i++) {
			for (j = 2; j <= k; j++) {
				eggFloor[i][j] = Integer.MAX_VALUE;
				for (x = 1; x <= j; x++) {
					res = 1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
					if (res < eggFloor[i][j])
						eggFloor[i][j] = res;
				}
			}
		}

		// eggFloor[n][k] holds the result
		System.out.println(Arrays.toString(eggFloor[n]));
		return eggFloor[n][k];
	}

}
