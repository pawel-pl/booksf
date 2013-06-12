package zillow;

import java.util.Arrays;
import java.util.Random;

/*
 * Given an array of numbers, nums, return an array of numbers products, 
 * where products[i] is the product of all nums[j], j != i.
 * Input : [1, 2, 3, 4, 5]
 * Output: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)] = [120, 60, 40, 30, 24]
 * You must do this in O(N) without using division.
 * 
 * http://stackoverflow.com/questions/2680548/interview-q-given-an-array-of-numbers-return-array-of-products-of-all-other-nu
 * http://stackoverflow.com/questions/56215/interesting-interview-questions
 * http://en.algoritmy.net/article/43676/Fisher-Yates-shuffle
 */
public class ArrayProductOfAllElements {

	public static void main(String[] args) {

		products1(new int[] { 1, 2, 3, 4, 5 });
		products2(new int[] { 1, 2, 3, 4, 5 });
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int[] products = new int[a.length];
		recursive(new int[] { 1, 2, 3, 4, 5 }, products, 0, 1);
		System.out.println(Arrays.toString(products));
		productExceptGiven(new int[] { 2, 3, 4, 5 }, new int[] { 1, 3, 2, 0 });
		shuffle();
	}

	public static void products1(int[] a) {

		int n = a.length;
		int[] products_below = new int[n];
		int p = 1;
		for (int i = 0; i < n; ++i) {
			products_below[i] = p;
			p *= a[i];
		}

		int[] products_above = new int[n];
		p = 1;
		for (int i = n - 1; i >= 0; --i) {
			products_above[i] = p;
			p *= a[i];
		}

		int[] products = new int[n]; // This is the result
		for (int i = 0; i < n; ++i) {
			products[i] = products_below[i] * products_above[i];
		}
		System.out.println(Arrays.toString(products));
	}

	public static void products2(int[] a) {

		int n = a.length;
		int[] products = new int[n];
		int p = 1;
		for (int i = 0; i < n; ++i) {
			products[i] = p;
			p *= a[i];
		}
		p = 1;
		for (int i = n - 1; i >= 0; --i) {
			products[i] = p * products[i];
			p *= a[i];
		}

		System.out.println(Arrays.toString(products));
	}

	public static int recursive(int[] a, int[] products, int index, int p) {

		if (index == a.length) {
			return 1;
		}
		products[index] = p;
		int result = recursive(a, products, index + 1, p * a[index]);
		products[index] = products[index] * result;

		return result * a[index];
	}

	public static void productExceptGiven(int input[], int index[]) {

		int[] out = new int[input.length];
		int len = input.length;
		int prod = 1, nzeros = 0;

		for (int i = 0; i < len; ++i) {
			if (input[i] != 0) {
				// compute product of non-zero elements
				prod *= input[i]; // ignore possible overflow problem
			} else {
				if (++nzeros == 2)
					// if number of zeros greater than 1 then out[i] = 0 for all
					// i
					System.out.println(Arrays.toString(out));
				return;
			}
		}

		//
		for (int i = 0; i < len; ++i) {
			if (nzeros == 1) {
				if (input[index[i]] == 0) {
					out[i] = prod;
				} else {
					out[i] = 0;
				}
			} else {
				out[i] = prod / input[index[i]];
			}
		}

		System.out.println(Arrays.toString(out));
	}
	
	public static void shuffle() {
		
		int[] a = new int[20];
		for(int i = 0; i < a.length - 1; i++){
			a[i] = i;
		}
		
		System.out.println(Arrays.toString(a));
		Random rand = new Random();
		for(int i = a.length - 1; i > 1; i--){
			int n = rand.nextInt(i);
			int temp = a[i];
			a[i] = a[n];
			a[n] = temp;
		}
		System.out.println(Arrays.toString(a));
	}
}
