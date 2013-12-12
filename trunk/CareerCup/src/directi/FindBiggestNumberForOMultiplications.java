package directi;

import java.util.ArrayList;
import java.util.List;

public class FindBiggestNumberForOMultiplications {

    public static void main(String[] args) {

	int n = 5;
	int o = 5;
	List<Integer> factors = new ArrayList<Integer>();
	System.out.println(checkNum(generateBiggestNum(n), o, factors));
	System.out.println(factors);

    }

    private static int generateBiggestNum(int n) {

	int num = 9;
	for (int i = 0; i < n - 1; i++) {
	    num *= 10;
	    num += 9;
	}

	return num;
    }

    private static int checkNum(int startNum, int o, List<Integer> factors) {

	int num = 0;

	for (num = startNum; num >= 2 * o; num--) {

	    if (findMultiplications(num, o, 0, 0, factors)) {
		return num;
	    }
	}

	return -1;
    }

    private static boolean findMultiplications(int num, int o, int noOfFactors, int prevFactor, List<Integer> factors) {

	if (noOfFactors > o) {
	    return false;
	}

	for (int i = 2; i <= 9; i++) {
	    if (num % i != 0 || i < prevFactor) {
		continue;
	    }
	    noOfFactors++;
	    if (noOfFactors == o) {
		factors.add(num);
		return true;
	    }
	    if (findMultiplications(num / i, o, noOfFactors, i, factors)) {
		factors.add(i);
		return true;
	    }

	}

	return false;
    }
}
