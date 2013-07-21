package facebook;

import java.util.Arrays;

public class TwoInTheMiddle {

    public static void main(String[] args) {

	int[] a = { 1, 3, 3, 2, 1 };
	threeWayPartition(a.clone(), 2);
    }

    public static void threeWayPartition(int[] a, int pivot) {

	int p = 0;
	int q = a.length - 1;
	for (int i = 0; i <= q;) {
	    if (a[i] < pivot)
		swap(a, i++, p++);
	    else if (a[i] > pivot)
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
