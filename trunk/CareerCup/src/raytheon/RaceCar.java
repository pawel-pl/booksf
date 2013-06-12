package raytheon;

import java.util.Random;

public class RaceCar {


	public static void main(String args[]) {

		RaceCar race = new RaceCar();
		race.raceCars();

	}
	
	public void raceCars() {
		
		int carAdist = 0;
		int carBdist = 0;
		int carAWins = 0;
		int carBWins = 0;
		int draws = 0;

		Random rand = new Random();

		//Number of simulations
		for (int i = 0; i < 100; i++) {
			carAdist = 0;
			carBdist = 0;

			//till one reach the end
			while (carAdist != 100 && carBdist != 100) {

				if (rand.nextInt(100) < 10) {
					carAdist = carAdist + 5;
				}
				if (rand.nextInt(100) < 60) {
					carBdist = carBdist + 1;
				}
			}
			if (carAdist > carBdist) {
				carAWins++;
			} else  if (carBdist > carAdist) {
				carBWins++;
			} else {
				draws++;
			}
		}
		
		System.out.println("Car A won: "+carAWins+", car B won: "+carBWins+", draws: "+draws);
		
	}

}
