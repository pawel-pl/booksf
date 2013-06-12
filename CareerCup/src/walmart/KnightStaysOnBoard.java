package walmart;

/*
 * http://topcoder.bgcoder.com/print.php?id=783
 * http://www.careercup.com/question?id=9918826
 */
public class KnightStaysOnBoard {

	public static void main(String[] args) {
		
		System.out.println(probability(1, 1, 4));
	
	}
	
	public static double probability(int x, int y, int n) {

		double numOfCorrectPos = findNumberOfCorrectPos(x, y, 0, n);
		double numOfAllJumps = Math.pow(8, n);
		System.out.println("numOfCorrectPos: "+numOfCorrectPos);
		System.out.println("numOfAllJumps: "+numOfAllJumps);
		
		return numOfCorrectPos/ numOfAllJumps;
	}

	public static double findNumberOfCorrectPos(int x, int y, int jumpCount, int n) {

		if (x < 1 || x > 8 || y < 1 || y > 8 || jumpCount > n) {
			return 0;
		}

		if (jumpCount == n) {
			return 1;
		}

		int num = 0;

		num += findNumberOfCorrectPos(x - 2, y + 1, jumpCount + 1, n);
		num += findNumberOfCorrectPos(x - 2, y - 1, jumpCount + 1, n);
		num += findNumberOfCorrectPos(x - 1, y + 2, jumpCount + 1, n);
		num += findNumberOfCorrectPos(x - 1, y - 2, jumpCount + 1, n);
		num += findNumberOfCorrectPos(x + 2, y + 1, jumpCount + 1, n);
		num += findNumberOfCorrectPos(x + 2, y - 1, jumpCount + 1, n);
		num += findNumberOfCorrectPos(x + 1, y + 2, jumpCount + 1, n);
		num += findNumberOfCorrectPos(x + 1, y - 2, jumpCount + 1, n);

		return num;
	}
}
