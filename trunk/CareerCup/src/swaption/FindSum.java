package swaption;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @see zillow.NumbersEqualToSum
 * @author spike
 *
 */
public class FindSum {

    /**
     * @param args
     */
    public static void main(String[] args) {

	int[] arr = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	printSubsets(arr, 4, 55);
    }

    private static void printSubsets(int[] arr, int x, int y) {
	
	printSubsets(arr, 1, x, y, y, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), new ArrayList<Set<Integer>>());
    }
    
    private static void printSubsets(int[] arr, int count, int numOfEl, int sum, int remainder, Set<Integer> inUse,
	    Set<Integer> procesedValues, Set<Integer> processedIndexes, List<Set<Integer>> alreadyFound) {

	for (int i = 0; i < arr.length; i++) {
	    if (inUse.contains(i) || processedIndexes.contains(i)) {
		continue;
	    }
	    int diff = remainder - arr[i];
	    inUse.add(i);
	    if (count + 1 < numOfEl) {
		printSubsets(arr, count + 1, numOfEl, sum, diff, inUse, procesedValues, processedIndexes, alreadyFound);
	    } else if (count + 1 == numOfEl) {
		if (procesedValues.contains(diff) && !isAlreadyFound(convertIndexesToValues(arr, inUse), alreadyFound)) {
		    alreadyFound.add(convertIndexesToValues(arr, inUse));
		    System.out.println(getElementsFromArray(arr, inUse, diff) + " = " + sum);
		}
	    }
	    if (count == 1) {
		processedIndexes.add(i);
		procesedValues.add(arr[i]);
	    }
	    inUse.remove(i);
	}
    }

    private static Set<Integer> convertIndexesToValues(int[] arr, Set<Integer> inUse) {

	Set<Integer> newMatch = new HashSet<Integer>();
	for (Integer index : inUse) {
	    newMatch.add(arr[index]);
	}
	return newMatch;
    }

    private static boolean isAlreadyFound(Set<Integer> newSet, List<Set<Integer>> previouslyFound) {

	for (Set<Integer> set : previouslyFound) {
	    if (set.containsAll(newSet)) {
		return true;
	    }
	}
	return false;
    }

    private static String getElementsFromArray(int[] arr, Set<Integer> indexes, int diff) {

	StringBuilder sb = new StringBuilder();
	for (Integer i : indexes) {
	    sb.append(arr[i] + " + ");
	}
	sb.append(diff);
	return sb.toString();
    }
}
