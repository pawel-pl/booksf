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

	// int k = 5;
	// int[] arr = { 5, 10, 3, 7, 13, 17, 4, 6 };

	int k = 3;
	// int[] arr = { 4, 5, 0, -2, -3, 1 };
	int[] arr = { 1, 2, 3 };
	// findPairs(arr, k);
	findCountOfSubarrays(arr, k);
    }

    public static void findCountOfSubarrays(int[] arr, int k) {

	int[] sums = new int[arr.length];
	int[] sums2 = new int[arr.length];
	int[] rems = new int[k];
	int[] rems2 = new int[k];
	sums[0] = arr[0];
	sums2[0] = arr[0] % k;
	rems2[sums2[0]]++;
	for (int i = 1; i < arr.length; i++) {
	    sums[i] = sums[i - 1] + arr[i];
	    sums2[i] = (sums2[i - 1] + arr[i]) % k;
	    rems2[sums2[i]]++;
	}
	for (int i = 0; i < arr.length; i++) {
	    rems[sums[i] % k]++;
	}
	System.out.println("Sums: " + Arrays.toString(sums));
	System.out.println("Rems: " + Arrays.toString(rems));
	System.out.println("Sums2: " + Arrays.toString(sums2));
	System.out.println("Rems2: " + Arrays.toString(rems2));

	int ans = 0;
	int ans2 = 0;
	for (int i = 0; i < k; i++) {
	    ans += rems[i] * (rems[i] - 1) / 2;
	    ans2 += rems2[i] * (rems2[i] - 1) / 2;
	}
	System.out.println("Ans: " + ans + ", ans2: " + ans2);
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
