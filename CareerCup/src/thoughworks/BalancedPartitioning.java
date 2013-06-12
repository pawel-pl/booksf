package thoughworks;

import java.io.IOException;

public class BalancedPartitioning {

    public static void main(String[] args) throws IOException {

	int sum = 0;
	int[] array = { 3, 1, 1, 2, 2, 1 };
	for (int member = 0; member < array.length; member++) {
	    sum += array[member];
	}

	boolean[] sol = new boolean[sum / 2 + 1];

	sol[0] = true;// empty array
	for (int i : array) {
	    for (int j = sum / 2; j >= i; j--) {
		if (sol[j - i])
		    sol[j] = true;
	    }
	}

	int halfsumcloser = sum / 2;
	for (; !sol[halfsumcloser]; halfsumcloser--)
	    ;
	System.out.println("The Minimum sum After partioning the array is :" + ((sum - halfsumcloser) - halfsumcloser));

    }
}
