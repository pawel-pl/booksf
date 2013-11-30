package facebook;

import java.util.ArrayList;
import java.util.List;

public class AllNumbersSum2N {

    /**
     * @param args
     */
    public static void main(String[] args) {

	int n = 4;
	List<Integer> result = new ArrayList<Integer>();
	findNum(1, n, result);
    }

    public static void findNum(int numToAdd, int n, List<Integer> result) {

	if (n == 0) {
	    System.out.println(result);
	    return;
	}
	if (n < 0 || numToAdd > n) {
	    return;
	}
	result.add(numToAdd);
	findNum(numToAdd, n - numToAdd, result);
	result.remove(result.size() - 1);
	findNum(numToAdd + 1, n, result);
    }
}
