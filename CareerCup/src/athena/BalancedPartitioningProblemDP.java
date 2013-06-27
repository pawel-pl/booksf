package athena;

/*
 * http://www.cs.cornell.edu/~wdtseng/icpc/notes/dp3.pdf
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BalancedPartitioningProblemDP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 5, 7, 3, 3 };
		//int[] arr = { 3, 2, 1 };
		//int[] arr = { 1, 5, 11, 5 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("Sum: " + sum);
		boolean[][] sums = new boolean[arr.length][sum + 1];
		for (int i = 0; i < sums.length; i++) {
			sums[i][0] = true;
		}
		sums[0][arr[0]] = true;
		for (int i = 1; i < sums.length; i++) {
			for (int j = 0; j < sums[0].length; j++) {
				if (sums[i - 1][j] == true) {
					sums[i][j] = true;
					sums[i][j + arr[i]] = true;
				}
			}
		}
		// printMatrix(sums);
		int half = sum / 2;
		while (!sums[sums.length - 1][half]) {
			half--;
		}
		System.out.println("Closest to half of the sum: " + half);
		Set<Integer> firstHalfIndexes = new HashSet<Integer>();
		int rowWithHalf = sums.length - 1;
		while (half > 0) {
			while (rowWithHalf >= 0 && sums[rowWithHalf][half]) {
				rowWithHalf--;
			}
			rowWithHalf++;
			firstHalfIndexes.add(rowWithHalf);
			half -= arr[rowWithHalf];
		}
		List<Integer> firstHalf = new ArrayList<Integer>(firstHalfIndexes.size());
		List<Integer> secHalf = new ArrayList<Integer>(arr.length - firstHalfIndexes.size());
		for (int i = 0; i < arr.length; i++) {
			if (firstHalfIndexes.contains(i)) {
				firstHalf.add(arr[i]);
			} else {
				secHalf.add(arr[i]);
			}
		}
		System.out.println("First team: " + firstHalf);
		System.out.println("Sec team: " + secHalf);
		System.out.println("Diff: " + Math.abs(firstHalf.size() - secHalf.size()));
	}

	public static void printMatrix(boolean[][] m) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

}
