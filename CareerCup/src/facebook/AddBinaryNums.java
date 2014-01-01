package facebook;

public class AddBinaryNums {

    public static void main(String[] args) {

	System.out.println(addBinaryNumbers("100011", "100100"));
	System.out.println(addBinaryNumbers("1111001", "10010"));
	System.out.println(addBinaryNumbers("01111111", "00101"));

    }

    public static String addBinaryNumbers(String number1, String number2) {

	char[] num1 = number1.toCharArray();
	char[] num2 = number2.toCharArray();

	int i = num1.length - 1;
	int j = num2.length - 1;
	int c = 0;
	int sum = 0;
	String result = "";
	while (i >= 0 && j >= 0) {
	    sum = (int) (num1[i--] - '0') + (int) (num2[j--] - '0') + c;
	    result = addResult(sum, result);
	    c = sum > 1 ? 1 : 0;
	}

	while (i >= 0) {
	    sum = (int) (num1[i--] - '0') + c;
	    result = addResult(sum, result);
	    c = sum > 1 ? 1 : 0;
	}

	while (j >= 0) {
	    sum = (int) (num2[j--] - '0') + c;
	    result = addResult(sum, result);
	    c = sum > 1 ? 1 : 0;
	}

	if (c == 1) {
	    result = "1" + result;
	}

	return result;
    }

    private static String addResult(int sum, String result) {

	switch (sum) {
	case 0:
	    result = "0" + result;
	    break;
	case 1:
	    result = "1" + result;
	    break;
	case 2:
	    result = "0" + result;
	    break;
	case 3:
	    result = "1" + result;
	    break;
	}

	return result;
    }
}
