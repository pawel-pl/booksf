package yahoo;

import java.util.Arrays;

/*
 * http://stackoverflow.com/questions/941447/quicksort-with-3-way-partition
 */
public class PivotInTheMiddle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 1, 2, 20, 34, 21, 55, 56, 20, 4 };
		threeWayPartition(a.clone(), 20);
	}

	public static void threeWayPartition(int[] a, int pivot) {

		int p = 0;
		int q = a.length - 1;
		for (int i = 0; i <= q;) {
			if (a[i] < pivot)
				// p element has been already checked against second condition when
				// it was indicated by i so we can move forward (i++)
				swap(a, i++, p++);
			else if (a[i] > pivot)
				// q element hasn't been checked against first condition yet
				// it wasn't indicated by i so we can't move forward (i++)
				swap(a, i, q--);
			else
				i++;
		}
	}

	private static void swap(int[] a, int i, int j) {

		System.out.println("Swap: " + a[i] + ", " + a[j]);
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
		System.out.println(Arrays.toString(a));
	}

}
