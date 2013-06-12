package zillow;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* Finding three elements in an array whose sum is closest to an given number.
 * 
 * http://www.kirupa.com/forum/showthread.php?237560-Find-Two-Numbers-in-an-Array-that-Sum-to-a-Particular-Value
 * http://stackoverflow.com/questions/2070359/finding-three-elements-in-an-array-whose-sum-is-closest-to-an-given-number
 */
public class NumbersEqualToSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] values = { 144, 29, 46, 55, 33, 64, 174, 144, 168, 129, 73, 186, 24, 163, 3, 165, 160, 79, 39, 3, 81,
				175, 183, 175, 15, 150, 177, 191, 29, 106, 104, 56, 58, 85, 172, 72, 119, 192, 134, 11, 10, 54, 34, 27,
				194, 182, 71, 183, 132, 147, 23, 78, 70, 13, 144, 93, 104, 177, 181, 62, 155, 26, 50, 172, 158, 17,
				139, 156, 105, 26, 162, 15, 65, 30, 174, 62, 175, 182, 121, 56, 23, 77, 179, 161, 168, 36, 25, 46, 137,
				178, 51, 21, 65, 41, 78, 71, 196, 142, 78, 33, 130, 81, 55, 15, 131, 145, 135, 99, 116, 104, 20, 6, 22,
				201, 135, 29, 148, 71, 110, 20, 104, 89, 105, 1, 10, 9, 53, 92, 75, 112, 161, 106, 196, 60, 163, 102,
				109, 182, 148, 56, 88, 47, 151, 22, 119, 97, 163, 77, 126, 16, 151, 112, 143, 15, 76, 133, 124, 49,
				114, 36, 183, 64, 4, 129, 201, 197, 161, 46, 103, 36, 58, 2, 78, 199, 113, 97, 53, 149, 60, 78, 63, 50,
				152, 150, 140, 113, 101, 85, 80, 123, 186, 78, 95, 105, 195, 74, 121, 44, 40, 94, 149, 34, 74, 78, 28,
				166, 126, 132, 51, 15, 200, 147, 77, 170, 171, 67, 67, 52, 57, 198, 186, 152, 69, 43, 194, 12, 37, 157,
				144, 128, 153, 168, 130, 121, 186, 200, 195, 192, 162, 180, 95, 94, 24, 39, 37, 131, 177, 103, 106, 62,
				28, 110, 145, 67, 99, 98, 137, 56, 26, 10, 56, 152, 36, 195, 150, 3, 87, 193, 16, 128, 186, 67, 122,
				196, 162, 24, 56, 12, 2, 160, 190, 84, 17, 13, 112, 11, 200, 177, 120, 26, 33, 23, 11, 176, 7, 160, 49,
				177, 92, 186, 176, 161, 175, 92, 30, 172, 186, 142, 145, 76, 44, 15, 171, 56, 158, 3, 9, 172, 92, 54,
				101, 197, 158, 191, 102, 157, 32, 193, 156, 164, 74, 10, 106, 91, 176, 32, 132, 69, 197, 188, 184, 109,
				5, 160, 200, 116, 55, 93, 143, 26, 82, 140, 52, 176, 120, 198, 178, 125, 122, 201, 44, 56, 96, 96, 29,
				175, 156, 113, 17, 18, 70, 158, 159, 193, 162, 153, 40, 67, 170, 177, 182, 40, 78, 192, 173, 151, 55,
				110, 142, 155, 56, 1, 134, 134, 50, 189, 105, 158, 34, 51, 17, 98, 131, 158, 89, 57, 158, 82, 112, 95,
				149, 78, 60, 31, 144, 27, 94, 4, 45, 88, 152, 157, 82, 188, 73, 67, 198, 199, 198, 123, 201, 20, 171,
				8, 115, 66, 144, 190, 126, 108, 5, 12, 14, 147, 35, 52, 139, 108, 57, 2, 128, 54, 157, 145, 75, 34, 26,
				63, 201, 124, 198, 42, 109, 153, 177, 47, 173, 150, 3, 143, 198, 167, 110, 66, 20, 151, 147, 115, 108,
				191, 142, 123, 169, 17, 127, 197, 86, 39, 144, 10, 165, 36, 151, 179, 185, 75, 39, 86, 194, 3 };

		Random randomNum = new Random();
		int sum = randomNum.nextInt(200);
		sum = sum < 10 ? sum + 10 : sum;
		System.out.println("Search sum is: " + sum);
		// findTwoNumbers(values, sum);
		findThreeNumbers(values, sum);

	}

	public static void findTwoNumbers(int a[], int sum) {

		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (!set.contains(a[i])) {
				int remainder = sum - a[i];
				if (set.contains(remainder)) {
					System.out.println(++count + ") Find sun: " + sum + " = " + a[i] + " + " + remainder);
				}
				set.add(a[i]);
			}
		}
	}

	public static void findThreeNumbers(int a[], int sum) {

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			int r1 = sum - a[i];
			for (int j = 0; j < a.length; j++) {
				if (j == i)
					continue;

				Set<Integer> alreadyCompared = new HashSet<Integer>();
				if (!set.contains(a[i]) && !alreadyCompared.contains(a[j])) {
					int remainder = r1 - a[j];
					alreadyCompared.add(a[j]);
					if (set.contains(remainder)) {
						System.out.println("Find sun: " + sum + " = " + a[i] + " + " + a[j] + " + " + remainder);
					}
				}
			}
			set.add(a[i]);
		}
	}

}
