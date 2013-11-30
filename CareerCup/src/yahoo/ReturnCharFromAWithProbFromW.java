package yahoo;

public class ReturnCharFromAWithProbFromW {

    static int binSearch(double[] W, int start, int end, double random) {
	if (start == end)
	    return start;
	int mid = (end - start) / 2;
	if (random <= W[mid])
	    return binSearch(W, start, mid, random);
	else
	    return binSearch(W, mid + 1, end, random);
    }

    static char generateRandom(double[] W, char[] A) {
	double random = Math.random(); // random double between 0 and 1
	return A[binSearch(W, 0, W.length - 1, random)]; //
    }

    public static void main(String[] args) {
	double W[] = { 0.2, 0.3, 0.5 };
	char A[] = { 'a', 'b', 'c' };

	// calculating cumulative probability
	for (int i = 1; i < W.length; i++) {
	    W[i] = W[i - 1] + W[i];
	}

	// calling multiple times and counting - for test only
	int count[] = { 0, 0, 0 };
	for (int i = 0; i < 10000; i++) {
	    char r = generateRandom(W, A);
	    count[r - 'a']++;
	}
	for (int i = 0; i < count.length; i++)
	    System.out.println((char) ('a' + i) + " - " + count[i]);
    }
}
