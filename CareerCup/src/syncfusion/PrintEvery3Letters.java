package syncfusion;

public class PrintEvery3Letters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "Elephants";
		if (s.length() % 3 == 0) {
			StringBuilder sb = new StringBuilder();
			int currentIndex = 2;
			while (currentIndex < s.length()) {
				sb.append(s.charAt(currentIndex));
				currentIndex = currentIndex + 3;
			}
			System.out.println(sb);
		} else {
			System.out.println(s);
		}
	}

}
