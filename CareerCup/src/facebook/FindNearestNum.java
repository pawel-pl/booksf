package facebook;

public class FindNearestNum {

    public static void main(String[] args) {

	int[] arr = { -1, 2, 5, 8, 11 };
	System.out.println(findNearestNum(arr, 0));
	System.out.println(findNearestNum(arr, 6));
    }

    public static int findNearestNum(int[] arr, int n) {

	int len = arr.length;
	if (len == 1)
	    return arr[0];
	if (n < arr[0])
	    return arr[0];
	if (n > arr[len - 1])
	    return arr[len - 1];

	int left = 0;
	int right = len - 1;

	while (left <= right) {
	    int mid = left + (right - left) / 2;

	    if (arr[mid] == n) {
		return n;
	    } else if (arr[mid] > n) {
		right = mid - 1;
	    } else {
		left = mid + 1;
	    }
	}
	System.out.println(arr[left] +", "+arr[right]);
	return Math.abs(arr[left] - n) > Math.abs(arr[right] - n) ? arr[right] : arr[left];
    }
}
