package wireless;

public class ArrayBContainsA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(isAppears("abc", "edabcxy"));
	}

	public static boolean isAppears(String a, String b) {
		boolean[] exists = new boolean[256];
		for (int i = 0; i != b.length(); i++) {
			exists[(int) (b.charAt(i))] = true;
		}
		for (int i = 0; i != a.length(); i++) {
			if (exists[(int) (a.charAt(i))] == false) {
				return false;
			}
		}
		return true;
	}

}
