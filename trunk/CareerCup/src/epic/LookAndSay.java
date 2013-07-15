package epic;

public class LookAndSay {

	public static void main(String[] args) {

		int num = 1;
		lookAndFeel(num, 6);
	}

	public static void lookAndFeel(int num, int k) {

		System.out.println(num);
		StringBuilder currentValue = new StringBuilder("1" + (char) (num + '0'));
		for (int i = 1; i < k; i++) {
			StringBuilder nextValue = new StringBuilder();
			System.out.println(currentValue);
			int counter = 1;
			for (int j = 1; j < currentValue.length(); j++) {
				while (j < currentValue.length() && currentValue.charAt(j) == currentValue.charAt(j - 1)) {
					counter++;
					j++;
				}
				nextValue.append(String.valueOf(counter) + currentValue.charAt(j - 1));
				counter = 1;
			}
			if (currentValue.charAt(currentValue.length() - 1) != currentValue.charAt(currentValue.length() - 2)) {
				nextValue.append("1" + currentValue.charAt(currentValue.length() - 1));
			}
			currentValue = nextValue;
		}
	}
}
