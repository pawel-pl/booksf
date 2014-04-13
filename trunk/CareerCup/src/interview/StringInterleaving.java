package interview;

public class StringInterleaving {

    public static void main(String[] args) {

	int[] arr = { 1, 2, 3, 4, 5, 2, 5, 4, 4 };
	int[] leftRightSum = new int[arr.length];
	int[] rightLeftSum = new int[arr.length];

	leftRightSum[0] = arr[0];
	for (int i = 1; i < arr.length; i++) {
	    leftRightSum[i] = arr[i] + leftRightSum[i - 1];
	}

	rightLeftSum[arr.length - 1] = arr[arr.length - 1];
	for (int i = arr.length - 2; i >= 0; i--) {
	    rightLeftSum[i] = arr[i] + rightLeftSum[i + 1];
	}

	for (int i = 0; i < arr.length - 1; i++) {
	    if (leftRightSum[i] == rightLeftSum[i + 1]) {
		System.out.println("Breaking point is at " + i);
	    }
	}
    }
}
