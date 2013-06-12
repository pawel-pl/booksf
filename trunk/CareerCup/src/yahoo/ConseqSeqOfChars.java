package yahoo;

public class ConseqSeqOfChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "ABCXYZACCD";
		StringBuilder sb = new StringBuilder();
		int prevChar = (int) s.charAt(0);
		sb.append((char) prevChar);
		for (int i = 1; i < s.length(); i++) {
			int newChar = (int) s.charAt(i);
			if (newChar != prevChar + 1 ) {
				System.out.println(sb);
				sb.setLength(0);
			}
			sb.append((char) newChar);
			prevChar = newChar;
		}
		
		System.out.println(sb);	
	}

}
