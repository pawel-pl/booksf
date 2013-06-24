package abs;

/*
 * Here's a simple solution. We start out assuming everyone's salary is in a certain range, say 0 - 1 trillion. 
 * The first person picks a number uniformly at random in that range and informs only the second person about this random number. 
 * Since this number is just random, it conveys no information. The second person adds their salary to the number and informs the third person about this sum. 
 * The third person receives no info from this because of the random element added in. 
 * The third person adds their salary to this running total and informs the first person about the sum. 
 * The first person knows the random number and subtracts it out, leaving the first person with the sum of the second and third person's salary. 
 * The first person could have obtained this info from the average anyway, so no extra information has been conveyed. 
 * Finally the first person adds their salary and divides by 3.
 * 
 * Let the individuals be labeled as A, B, C. Let's suppose that we place them in a circular queue, 
 * each person subtracts some undisclosed portion from his salary and tells it to the next person in the ordering. 
 * Each individual receives this value and "adds" it to his own salary. Then we go through and add up the values, and divide by 3.
 */
public class ThreePeopleSalary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
