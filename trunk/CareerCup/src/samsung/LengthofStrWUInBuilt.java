package samsung;

public class LengthofStrWUInBuilt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s = "What is the length";
		int i = 0;
		try {
			while (true) {
				s.charAt(i);
				i++;
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("the length is " + i);
		}

	}

}
