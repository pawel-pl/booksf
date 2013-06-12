package linkedin;

import java.util.Set;
import java.util.TreeSet;

public class FindCommonElementsIn2Arr {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6 };
		int[] b = { 5, 6, 7, 8, 9 };
		Set<Integer> result = new TreeSet<Integer>();

		int i = 0;
		int j = 0;

		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				result.add(a[i]);
				i++;
				j++;
			} else if (a[i] > b[j]) {
				j++;
			} else if (a[i] < b[j]) {
				i++;
			}
		}
		System.out.println(result);
	}

}
