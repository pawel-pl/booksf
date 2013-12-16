package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSumCombinations {

    public static void main(String[] args) {

	List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 1, 2, 2, 4 }));
	List<Integer> result = new ArrayList<Integer>();
	printSumCombinations(numbers, 4, result, 0);
    }

    public static void printSumCombinations(List<Integer> numbers, int sum, List<Integer> result, int currentIndex) {

	if (sum == 0) {
	    System.out.println(result);
	    return;
	}

	if (currentIndex > numbers.size() - 1) {
	    return;
	}
	if (numbers.get(currentIndex) != 0) {
	    result.add(currentIndex);
	    printSumCombinations(numbers, sum - numbers.get(currentIndex), result, currentIndex + 1);
	    result.remove(result.size() - 1);
	}
	printSumCombinations(numbers, sum, result, currentIndex + 1);
    }
}
