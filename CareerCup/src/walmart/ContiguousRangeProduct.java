package walmart;

public class ContiguousRangeProduct {

	public static void main(String[] args) {

		//int[] a = { 6, 7, -8, 9, 8, -7, 6 };
		int[] a = { 6, 7, 0, -6, 2, -7, 0, 8, -7, 6 };
		findProduct(a);
	}

	public static void findProduct(int[] a) {

		int[] negValues = new int[a.length];
		int numOfZeros = 0;
		int numOfNegValues = a[a.length - 1] < 0 ? 1 : 0;
		int totalNumOfNegValues = a[a.length - 1] < 0 ? 1 : 0;
		int maxProd = 0;
		int currentProd = 1;
		int start = 0;
		int currentStart = 0;
		int end = 0;

		for (int i = a.length - 2; i >= 0; i--) {
			negValues[i] = numOfNegValues;
			if (a[i] == 0) {
				numOfZeros++;
				numOfNegValues = 0;
			} else if (a[i] < 0) {
				totalNumOfNegValues++;
				numOfNegValues++;
			}
		}
		if (numOfZeros == a.length) {
			System.out.println("Product is equal 0");
			return;
		}
		if (numOfZeros == 0 && totalNumOfNegValues % 2 == 0) {
			System.out.println("Full range");
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0 || (a[i] < 0 && negValues[i] == 0 && currentProd > 0)) {
				currentStart = i + 1;
				currentProd = 1;
				continue;
			}
			currentProd *= a[i];
			if (currentProd > maxProd) {
				maxProd = currentProd;
				start = currentStart;
				end = i;
			}

		}
		System.out.println("Start: " + start + ", end: " + end + ", prod: " + maxProd);
	}

}
