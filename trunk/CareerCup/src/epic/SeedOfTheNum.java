package epic;

/*
 * Eg : 1716 = 143*1*4*3 = 1716 so 143 is the seed of 1716. find all possible 
 */
public class SeedOfTheNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		findSeed(1716);
	}

	public static void findSeed(int num) {

		int seed = (int)Math.ceil(Math.sqrt(num));
		while (seed <= num / 2) {
			if (num % seed == 0) {
				int product = seed;
				int factor = seed;
				while (factor > 0) {
					int mod = factor % 10;
					product *= mod;
					factor = factor / 10;
				}
				if (product == num) {
					System.out.println("Found seed: " + seed + " for num: " + num);
				}
			}
			seed++;
		}
	}
}
