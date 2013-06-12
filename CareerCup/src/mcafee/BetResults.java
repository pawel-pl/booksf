package mcafee;

public class BetResults {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		betResults(20, "WLLW");
		betResults(12, "WWWWWWWW");
		betResults(15, "LLLWLLLL");
	}

	private static void betResults(int amount, String betResults) {

		int value = 1;
		for (int i = 0; i < betResults.length(); i++) {
			if(value > amount) {
				return;
			}
			char ch = betResults.charAt(i);
			if (ch == 'W') {
				amount += value;
				value = 1;
			} else {
				amount -= value;
				value *= 2;
			}
		}
		
		System.out.println(amount);
	}

}
