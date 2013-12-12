package adobe;

public class GenerateAnyFibNum {

    private static int countDigits(int num) {

	int count = 0;
	while (num > 0) {
	    num /= 10;
	    count++;
	}

	return count;
    }

    private static int appendNum(int orgNum, int newNum) {

	if (orgNum == 0 || newNum == 0) {
	    return 0;
	}
	int noOfDigits = countDigits(newNum);
	if (noOfDigits + countDigits(orgNum) > 9) {
	    return 0;
	}
	orgNum = orgNum * (int) Math.pow(10, noOfDigits) + newNum;

	return orgNum;
    }

    public static void main(String[] args) {

	int from = 1;
	int to = 1000000000;
	for (int firstDigit = 1; firstDigit < to; firstDigit++) {

	    int n = appendNum(appendNum(firstDigit, firstDigit), firstDigit + firstDigit);
	    if (n > to || n == 0) {
		System.out.println("First: " + firstDigit);
		break;
	    }

	    for (int secDigit = firstDigit; secDigit < to; secDigit++) {
		n = appendNum(appendNum(firstDigit, secDigit), firstDigit + secDigit);
		if (n == 0) {
		    break;
		}
		int prev1 = firstDigit + secDigit;
		int prev2 = secDigit;
		while (n != 0 && n <= to) {
		    if (n >= from) {
			if (n == 499500999) {
			    System.out.println("Bingo!");
			}
			System.out.println(n);
		    }
		    int temp = prev2 + prev1;
		    prev2 = prev1;
		    prev1 = temp;
		    n = appendNum(n, temp);
		}
	    }
	}
    }

}
