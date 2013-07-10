package directi;

public class FindTripletSumInRange12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		double[] arr = { 1.9, 0.2, 0.3, 0.4 };
		double[] arr = { 1.9, 0.2, 0.5, 0.36 };
		findTriplet(arr);
	}

	public static boolean findTriplet(double[] arr) {

		double first = Float.MAX_VALUE;
		double sec = Float.MAX_VALUE;
		double third = Float.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 2) {
				continue;
			}
			if (arr[i] <= first) {
				third = sec;
				sec = first;
				first = arr[i];
			} else if (arr[i] <= sec) {
				third = sec;
				sec = arr[i];
			} else if (arr[i] <= third) {
				third = arr[i];
			}
			double res = first + sec + third;
			if (res > 1 && res < 2) {
				System.out.println("Found triplet: " + first + " + " + sec + " + " + third + " = " + res);
				return true;
			}
		}
		System.out.println("Triplet was not found");
		
		return false;
	}

}
