package linkedin;

public class FindShortestStringContainingWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String text = "v d e g h b s d f c f f s g a f g t y c g h a d d k s e b i o p c f d a f b";
		char[] a = text.toCharArray();
		int minDist = Integer.MAX_VALUE;
		int minW1Index = -1;
		int minW2Index = -1;
		int minW3Index = -1;
		int currentMinDist = Integer.MAX_VALUE;
		int currentW1Index = -1;
		int currentW2Index = -1;
		int currentW3Index = -1;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 'a') {
				currentW1Index = i;
				currentMinDist = calculateDist(currentW1Index, currentW2Index, currentW3Index);
				if (currentMinDist < minDist) {
					minDist = currentMinDist;
					minW1Index = currentW1Index;
					minW2Index = currentW2Index;
					minW3Index = currentW3Index;
				}
			} else if (a[i] == 'b') {
				currentW2Index = i;
				currentMinDist = calculateDist(currentW2Index, currentW1Index, currentW3Index);
				if (currentMinDist < minDist) {
					minDist = currentMinDist;
					minW1Index = currentW1Index;
					minW2Index = currentW2Index;
					minW3Index = currentW3Index;
				}
			} else if (a[i] == 'c') {
				currentW3Index = i;
				currentMinDist = calculateDist(currentW3Index, currentW1Index, currentW2Index);
				if (currentMinDist < minDist) {
					minDist = currentMinDist;
					minW1Index = currentW1Index;
					minW2Index = currentW2Index;
					minW3Index = currentW3Index;
				}
			}
		}
		if (minW1Index != -1 && minW2Index != -1 && minW3Index != -1) {
			System.out.println("Min dist is: " + minDist + ", w1: " + minW1Index + ", w2: " + minW2Index + ", w3: "
					+ minW3Index);
			System.out.println(text.substring(64));
		} else {
			System.out.println("Words not found");
		}
	}

	private static int calculateDist(int recentlyFound, int w2, int w3) {

		if (recentlyFound == -1 || w2 == -1 || w3 == -1) {
			return Integer.MAX_VALUE;
		}

		return recentlyFound - Math.min(w2, w3);
	}

}
