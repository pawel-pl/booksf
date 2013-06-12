package linkedin;

public class IsNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isNumber(char[] str) {

		// trim(str); // remove leading and trailing spaces.
		int i = 0;
		boolean dec = false; // is decimal?
		while (i < str.length) {
			if (str[i] == '-' || str[i] == '+') {
				if (i != 0)
					return false;
			} else if (str[i] == '.') {
				if (dec)
					return false; // we can have only one decimal point in a
									// number
				else
					dec = true;

				if (i == str.length - 1) // make sure decimal is not last char
											// in the
					// string
					return false;
			} else if (str[i] <= '0' || str[i] >= '9')
				return false;
			i++;
		}

		return false;
	}
}
