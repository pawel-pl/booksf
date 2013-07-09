package directi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
 * http://www.careercup.com/question?id=15909674
 * http://stackoverflow.com/questions/12545544/optimal-algorithm-needed-for-finding-pairs-divisible-by-a-given-integer-k
 * http://www.careercup.com/question?id=14820665
 * 
 * http://stackoverflow.com/questions/11772145/number-of-subarrays-where-sum-of-numbers-is-divisible-by-k
 * http://stackoverflow.com/questions/13089010/find-longest-subarray-whose-sum-divisible-by-k
 * http://en.literateprograms.org/Subarray_with_Sum_Divisible_by_Length_of_Array_(Java)#chunk def:found solution
 */
public class PairSumIsDivisibleByK {

    /**
     * @param args
     */
    public static void main(String[] args) {

	int k = 6;
	// int[] arr = { 11, 6, 7, 2, 2, 4, 1 };

	// int k = 6;
	// int[] arr = { 4, 5, 0, -2, -3, 1 };
	int[] arr = { 2, -2, -3 };
	// int[] arr = { 1, 2, 3 };
	// findPairs(arr, k);
	// findSubarrays(arr, k);
	findCount(arr, k);
    }

    public static void findCount(int[] a, int k) {

	int[] B = new int[k];
	B[0]++;
	int s = 0;
	for (int i = 0; i < a.length; i++) {
	    System.out.println(s);
	    s = (s + a[i]) % k;
	    B[s]++;
	}
	int ans = 0;
	for (int i = 0; i < k; i++) {
	    ans += B[i] * (B[i] - 1) / 2;
	}
	System.out.println(ans);
    }

    public static void findCountOfSubarrays(int[] a, int k) {

	int[] b = new int[a.length + 1];
	b[0] = 0;
	for (int i = 0; i < a.length; i++) {
	    b[i + 1] = (b[i] + a[i]) % k;
	}
	int[] c = new int[k];
	// Arrays.fill(c, -1);
	for (int i = 0; i < b.length; i++) {
	    int pos = b[i];
	    if (c[pos] < 0)
		c[pos] = i;
	    else {
		int begin = c[pos], end = i;
		int sum = 0;
		for (int j = begin; j < end; j++)
		    sum += a[j];

		System.out.println("found solution: subarray from index " + begin + " (inclusive) to " + end
			+ " (exclusive)");
		System.out.println("has sum = " + sum + ", which is divisible by length of array " + a.length);

		return;
	    }
	}
	// you are not supposed to get here
	System.err.println("You broke math.");
    }

    public static void findSubarrays(int[] a, int k) {

	int[] b = new int[a.length + 1];
	b[0] = 0;
	for (int i = 0; i < a.length; i++) {
	    b[i + 1] = (b[i] + a[i]) % k;
	}
	int[] c = new int[k];
	Arrays.fill(c, -1);
	for (int i = 0; i < b.length; i++) {
	    int pos = b[i];
	    if (c[pos] < 0)
		c[pos] = i;
	    else {
		int begin = c[pos], end = i;
		int sum = 0;
		for (int j = begin; j < end; j++)
		    sum += a[j];

		System.out.println("found solution: subarray from index " + begin + " (inclusive) to " + end
			+ " (exclusive)");
		System.out.println("has sum = " + sum + ", which is divisible by length of array " + a.length);

		return;
	    }
	}
	// you are not supposed to get here
	System.err.println("You broke math.");
    }

    public static void findPairs(int[] arr, int k) {

	Map<Integer, HashSet<Integer>> remainders = new HashMap<Integer, HashSet<Integer>>(5);

	for (int i = 0; i < arr.length; i++) {
	    int r = arr[i] % k;
	    if (!remainders.containsKey(r)) {
		remainders.put(r, new HashSet<Integer>());
	    }
	    remainders.get(r).add(arr[i]);
	}
	List<Integer> temp = new ArrayList<Integer>();
	if (remainders.containsKey(0)) {
	    if (remainders.get(0).size() % 2 == 0) {
		temp.addAll(remainders.get(0));
		for (int i = 0; i < temp.size() / 2; i++) {
		    System.out.println(temp.get(i) + " -> " + temp.get(temp.size() - i - 1));
		}
	    }
	}
	if (k % 2 == 0) {
	    if (remainders.containsKey(k / 2)) {
		if (remainders.get(k / 2).size() % 2 == 0) {
		    temp.clear();
		    temp.addAll(remainders.get(k / 2));
		    for (int i = 0; i < temp.size() / 2; i++) {
			System.out.println(temp.get(i) + " -> " + temp.get(temp.size() - i - 1));
		    }
		}
	    }
	}
	for (int i = 1; i <= k / 2; i++) {
	    if (remainders.containsKey(i) && remainders.containsKey(k - i)) {
		List<Integer> l1 = new ArrayList<Integer>(remainders.get(i));
		List<Integer> l2 = new ArrayList<Integer>(remainders.get(k - i));
		if (l1.size() != l2.size()) {
		    continue;
		}
		for (int j = 0; j < l1.size(); j++) {
		    for (int z = 0; z < l2.size(); z++) {
			System.out.println(l1.get(j) + " -> " + l2.get(z));
		    }
		}
	    }
	}
    }
}
