package walmart;

public class ClosestPerfectSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int num = 1678;
		double numSqrt = Math.sqrt(num);
		int lowerValue = 0;
		int heigherValue = 0;
		if(numSqrt == (int)numSqrt) {
			lowerValue = (int)numSqrt-1;
		} else {
			lowerValue = (int)numSqrt;
		}
		heigherValue = (int)numSqrt+1;
		double hSq = Math.pow(heigherValue, 2);
		double lSq = Math.pow(lowerValue, 2);
		
		if(num - lSq < hSq - num) {
			System.out.println(lSq);
		} else {
			System.out.println(hSq);
		}
	}

}
