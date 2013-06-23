package a9;

import java.util.Random;

public class Rand7Generator {

    public static void main(String[] args) {

	
	for (int i = 0; i < 10; i++) {
	    System.out.println(rand7());
	}
    }

    public static int rand7() // random number from 1 - 7
    {
	int r = 0;
	do {
	    int a = new Random().nextInt(5); // rand(5) - 1; uniformly at random
					     // from 0 to 4
	    int b = new Random().nextInt(5);// rand(5) - 1; //uniformly at
					    // random from 0 to 4
	    r = 5 * b + a; // uniformly at random from 0 to 24
	} while (r >= 21); // in this event, we have to roll again
	// postcondition of loop: we have a number uniformly at random between 0
	// and 20

	return r % 7 + 1;

	// there are 3 numbers in [0, 20] for each possible return value
	// so each has equal probability.
    }
}
