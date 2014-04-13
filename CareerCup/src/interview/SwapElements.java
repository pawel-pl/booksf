package interview;

import java.util.Arrays;

public class SwapElements {

    public static void main(String[] args) {

	String[] a = { "A1", "A2", "A3", "A4", "A5", "A6", "B1", "B2", "B3", "B4", "B5", "B6" };
	swap(a, 6);
    }

    public static void swap(String a[], int n) {

	int ap = 1;
	int bp = n;
	int posOfUnassignedA = n;
	for (ap = 1; ap < a.length - 1; ap++) {
	    String temp = a[ap];
	    if (ap % 2 == 1) {
		a[ap] = a[bp];
		a[bp] = temp;
		bp++;
	    } else {
		a[ap] = a[posOfUnassignedA];
		a[posOfUnassignedA] = temp;
		posOfUnassignedA++;
	    }
	}
	System.out.println(Arrays.toString(a));
    }

}
