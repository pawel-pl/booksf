package guruji;

import java.util.Arrays;

public class PrintCombOf2and3 {

    public static void main(String[] args) {

	int[] arr = { 1, 2, 3, 4 };
	int n = 3;
	for (int i = 2; i <= n; i++) {
	    printComb(arr, 0, new int[i], 0);
	}
    }

    public static void printComb(int[] arr, int start, int[] result, int pos) {

	if (pos == result.length) {
	    System.out.println(Arrays.toString(result));
	    return;
	}
	for (int i = start; i < arr.length; i++) {
	    result[pos] = arr[i];
	    printComb(arr, i + 1, result, pos + 1);
	}
    }
}
