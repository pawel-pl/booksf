package magma;

/*
 * while(stat < end )
 {
 if( A[mid == KeyElem )
 {
 -----
 }
 else if( A[mid] < KeyElem )
 {
 ------
 }
 else
 {
 ----
 }
 ------
 }// end of While
 */
public class BinSearchSingleComp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		binSearch(a, a.length, 5);
		binSearch2(a, a.length, 5);
	}

	private static int binSearch(int A[], int n, int key) {

		int s = 0;
		int e = n - 1;
		int m;
		while (s < e) {
			m = (s + e) / 2;
			if (key <= A[m]) {
				e = m;
			} else {
				s = m + 1;
			}
		}
		if (A[e] == key) {
			System.out.printf("Key %d present at location %d\n", key, e);
			return e;
		} else {
			System.out.printf("Key Not Present in List\n");
			return -1;
		}
	}

	private static int binSearch2(int A[], int n, int key) {

		int s = 0;
		int e = n - 1;
		int m;
		while (s < e) {
			m = (s + e) / 2;
			if (A[m] < key) {
				s = m + 1;
			} else {
				e = m;
			}

		}
		if (A[e] == key) {
			System.out.printf("Key %d present at location %d\n", key, e);
			return e;
		} else {
			System.out.printf("Key Not Present in List\n");
			return -1;
		}
	}
}
