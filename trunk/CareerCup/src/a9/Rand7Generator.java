package a9;

import java.util.Random;

/*
 * Here's how. By calling rand5() twice and combining them using 5*firstValue + lastValue, I got a number uniformly at random between 0 and 24 (see why?). 
 * Now, I simply decided to accept only numbers between 0 and 20, since those numbers taken mod 7 give each value mod 7 exactly 3 opportunities to come up. 
 * So thus far things are equiprobable. Now what to do for the range 21-24? Since there's 4 numbers in that range and no way to distribute 4 numbers 
 * into 7 buckets equally, I simply roll again.
 * If you wanted to make rand8 with rand6, you'd be looking at rolling twice to get a number from 0 to 35 uniformly at random. 
 * Then you'd accept 0-31 (gives each number mod 8 four opportunities to occur), and you'd roll again for 32-35. 
 * But that would be kind of dumb for 6 and 8, because some numbers of the form 6^N are divisible by 8. 
 * You could actually roll exactly 3 times, get a number in the range 0-215 and take that modulo 8. Since each bucket would have 27 values exactly, 
 * this would be equiprobable. No such finite solution is available for 5 and 7 because they are coprime. More generally, the roll number needs to contain 
 * all the distinct prime factors contained in the target number for a finite solution to be available. 5 does not have as factors all the distinct prime 
 * factors of 7. 6 does in fact have as factors all the distinct prime factors of 8.
 */
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
