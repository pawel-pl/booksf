package salesforce;

public class RemoveChar {

    public static void main(String[] args) {

	removeChar("google", 'g');
    }

    public static void removeChar(String str, char ch) {

	int pos = 0;
	char[] input = str.toCharArray();
	for (int i = 0; i < input.length; i++) {
	    if (input[i] != ch) {
		input[pos++] = input[i];
	    }
	}
	System.out.println(new String(input, 0, pos));
    }
}
