package deshaw;

public class CombinationOfAandB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		findCombination(3);
	}

	public static void findCombination(int count) {

		StringBuilder sb = new StringBuilder();
		findCombination(count, count, sb);
	}

	public static void findCombination(int countA, int countB, StringBuilder sb) {

		if (countA == 0 && countB == 0) {
			System.out.println(sb);
			return;
		}

		if (countA > 0) {
			sb.append("A");
			findCombination(countA - 1, countB, sb);
			sb.setLength(sb.length() - 1);
		}
		if (countB > countA) {
			sb.append("B");
			findCombination(countA, countB - 1, sb);
			sb.setLength(sb.length() - 1);
		}
	}
}
