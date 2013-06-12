package zycus;

public class SecondLargestNumber {

    public static void main(String[] args) {

	int[] arr = { 1, 2, 2, 5, 3, 9, 8 };
	int largest = 0;
	int secLargest = 0;
	if (arr.length > 1) {
	    if (arr[0] > arr[1]) {
		largest = arr[0];
		secLargest = arr[1];
	    } else {
		largest = arr[1];
		secLargest = arr[0];
	    }

	    System.out.println(findSecondLargestNumber(arr, 2, arr.length, largest, secLargest));
	}

    }

    public static int findSecondLargestNumber(int[] arr, int index, int n, int largest, int secLargest) {

	if (index == n) {
	    return secLargest;
	}

	if (arr[index] > largest) {
	    secLargest = largest;
	    largest = arr[index];
	} else if (arr[index] > secLargest) {
	    secLargest = arr[index];
	}

	return findSecondLargestNumber(arr, index + 1, n, largest, secLargest);
    }

}
