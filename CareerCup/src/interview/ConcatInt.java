package interview;

public class ConcatInt {

    public static void main(String[] args) {

	long a = 18965;
	long b = 785213697;
	concat(a, b);
    }

    private static void concat(long a, long b) {

	long temp = b;
	while (temp > 0) {
	    temp /= 10;
	    a *= 10;
	}
	a += b;
	System.out.println(a);
    }

}
