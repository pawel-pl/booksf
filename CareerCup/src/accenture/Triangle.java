package accenture;

public class Triangle {

	public static void main(String arg[]) {

		int height = 4;
		int totalNumOfStars = height - 1;
		int charsPerLine = 2 * totalNumOfStars + 1;
		for (int i = 0; i < height; i++) {
			int numOfStars = totalNumOfStars - i;
			for (int j = numOfStars; j > 0; j--) {
				System.out.print("*");
			}
			boolean printChar = false;
			for (int j =  charsPerLine - 2 * numOfStars; j > 0; j--) {
				if (printChar) {
					System.out.print("*");
				} else {
					System.out.print(i + 1);
				}
				printChar = !printChar;
			}

			for (int j = numOfStars; j > 0; j--) {
				System.out.print("*");
			}

			System.out.println();
		}
	}
}
