package tribal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * http://www.geeksforgeeks.org/sort-elements-by-frequency/
 */
public class SortByFreq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 3, 4, 2, 5, 3, 3, 4, 2, 1, 5 };

		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> firstOccuranceMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (freqMap.containsKey(a[i])) {
				freqMap.put(a[i], freqMap.get(a[i]) + 1);
			} else {
				freqMap.put(a[i], 1);
			}
			if (!firstOccuranceMap.containsKey(a[i])) {
				firstOccuranceMap.put(a[i], i);
			}
		}

		System.out.println(Arrays.toString(a));
		quickSortByFreq(a, 0, a.length - 1, freqMap);
		System.out.println(Arrays.toString(a));
		quickSortEqualFreq(a, 0, a.length - 1, freqMap, firstOccuranceMap);
		System.out.println(Arrays.toString(a));
	}

	public static int partitionByFreq(int i, int j, int[] a, Map<Integer, Integer> freq) {

		int pivot = freq.get(a[(i + j) / 2]);

		while (i <= j) {

			while (freq.get(a[i]) < pivot) {
				i++;
			}

			while (freq.get(a[j]) > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}

		return i;
	}

	public static void quickSortByFreq(int[] a, int start, int end, Map<Integer, Integer> freq) {

		int i = partitionByFreq(start, end, a, freq);

		if (i - 1 > start) {
			quickSortByFreq(a, start, i - 1, freq);
		}
		if (i < end) {
			quickSortByFreq(a, i, end, freq);
		}
	}

	public static int partitionEqualFreq(int i, int j, int[] a, Map<Integer, Integer> freq, Map<Integer, Integer> firstOccuranceIndex) {

		int pivot = a[(i + j) / 2];

		while (i <= j) {

			while (freq.get(a[i]) != freq.get(pivot) || firstOccuranceIndex.get(a[i]) < firstOccuranceIndex.get(pivot)) {
				i++;
			}

			while (freq.get(a[j]) != freq.get(pivot) || firstOccuranceIndex.get(a[j]) > firstOccuranceIndex.get(pivot)) {
				j--;
			}

			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}

		return i;
	}

	public static void quickSortEqualFreq(int[] a, int start, int end, Map<Integer, Integer> freq,
			Map<Integer, Integer> occ) {

		int i = partitionEqualFreq(start, end, a, freq, occ);

		if (i - 1 > start) {
			quickSortEqualFreq(a, start, i - 1, freq, occ);
		}
		if (i < end) {
			quickSortEqualFreq(a, i, end, freq, occ);
		}
	}

}
