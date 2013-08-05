package adobe;

/*
 * http://www.careercup.com/question?id=20981680
 */
public class Coins100Beggars3 {

    public static void main(String[] args) {

	for (int c = 25; c >= 0; c--) {
	    for (int b = 50; b >= 0; b--) {
		if (100 - c - b <= 75) {
		    System.out.println("A = " + (100 - c - b) + ", B = " + b + ", C = " + c);
		}
	    }
	}
    }
}
