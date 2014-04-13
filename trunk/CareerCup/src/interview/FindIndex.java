package interview;

public class FindIndex {

    public static void main(String[] args) {

	System.out.println(findIndex(10000));

    }

    public static int findIndex(int n) {
	if (n < 10) {
	    return n - 1;
	} else if (n < 100) {
	    return (n - 10) * 2 + 9;
	} else if (n < 1000) {
	    return (n - 100) * 3 + 90 * 2 + 9;
	} else if (n < 10000) {
	    return (n - 1000) * 4 + 900 * 3 + 90 * 2 + 9;
	} else {
	    return 9000 * 4 + 900 * 3 + 90 * 2 + 9;
	}
    }
}
