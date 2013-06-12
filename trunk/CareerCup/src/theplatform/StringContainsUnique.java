package theplatform;

import java.util.Arrays;

public class StringContainsUnique {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

    public boolean hasUniqueChars(String a) {
	
	for (int i = 0; i < a.length(); i++) {
	    if (a.charAt(i) == a.charAt(i + 1))
		return false;
	}
	return true;
    }

    public static String sortString(String s) {

	char[] arr = s.toCharArray();
	Arrays.sort(arr);
	return String.valueOf(arr);
    }

}
