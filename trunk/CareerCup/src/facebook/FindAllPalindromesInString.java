package facebook;

public class FindAllPalindromesInString {

    public static void main(String[] args) {

	find("ababa");
    }

    public static int find(String inputText) {
	if (inputText == null) {
	    System.out.println("Input cannot be null!");
	    return 0;
	}
	// ODD Occuring Palindromes
	int len = inputText.length();
	int palindromes = len;
	System.out.println("Odd:");
	for (int i = 1; i < len - 1; i++) {
	    for (int j = i - 1, k = i + 1; j >= 0 && k < len; j--, k++) {
		System.out.println("i: " + i + ", j: " + j + ", k: " + k);
		if (inputText.charAt(j) == inputText.charAt(k)) {
		    palindromes++;
		    System.out.println(inputText.subSequence(j, k + 1));
		} else {
		    break;
		}
	    }
	}
	// EVEN Occuring Palindromes
	System.out.println("Even:");
	for (int i = 1; i < len - 1; i++) {
	    for (int j = i, k = i + 1; j >= 0 && k < len; j--, k++) {
		System.out.println("i: " + i + ", j: " + j + ", k: " + k);
		if (inputText.charAt(j) == inputText.charAt(k)) {
		    palindromes++;
		    System.out.println(inputText.subSequence(j, k + 1));
		} else {
		    break;
		}
	    }
	}
	return palindromes;
    }
}
