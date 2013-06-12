package usinter;

/*
 * http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
 */
public class FindPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isPrime(int n) {
		
		for (int i = 2; 2 * i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
