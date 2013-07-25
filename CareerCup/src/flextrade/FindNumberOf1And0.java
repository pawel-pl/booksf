package flextrade;

public class FindNumberOf1And0 {

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 1, 0, 0, 0 };
		int left = 0;
		int right = a.length - 1;
		int pivot = a[0] == 1 ? 1 : 0;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (a[mid] == pivot) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		System.out.println(left);
	}
}
