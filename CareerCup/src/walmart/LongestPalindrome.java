package walmart;

public class LongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String[] strings = {"aba","abcdcba","123454321"};
		int maxL = 0;
		String maxPali = null;
		
		for(String s : strings) {
			if(isPalidrome(s) && s.length() > maxL) {
				maxL = s.length();
				maxPali = s;
			}
		}
		
		System.out.println(maxPali);

	}
	
	public static boolean isPalidrome(String s) {
		
		int i = 0;
		int j = s.length()-1;
		
		while(i < j) {
			if(s.charAt(i++) != s.charAt(j--)){
				break;
			}
		}
		
		return i == j;
	}

}
