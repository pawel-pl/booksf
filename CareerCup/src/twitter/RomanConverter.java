package twitter;

/** 
* This program will convert Roman numerals to ordinary arabic numerals
* and vice versa.  The user can enter a numerals of either type.  Arabic
* numerals must be in the range from 1 to 3999 inclusive.  The user ends
* the program by entering an empty line.
*/
public class RomanConverter {

  public static void main(String[] args) {

	  RomanNumeral rn = new RomanNumeral(114);
	  RomanNumeral rn2 = new RomanNumeral("CXIV");
	  System.out.println(rn.toString());
	  System.out.println(rn2.toInt());
  }

} 
