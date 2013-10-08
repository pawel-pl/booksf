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
		if (currentValue.charAt(j) == currentValue.charAt(j - 1)) {
		    counter++;
		    continue;
		}
		nextValue.append(counter).append(currentValue.charAt(j - 1));
		counter = 1;
	    }
	    nextValue.append(counter).append(currentValue.charAt(currentValue.length() - 1));
	    currentValue = nextValue;
	}
    }
}
