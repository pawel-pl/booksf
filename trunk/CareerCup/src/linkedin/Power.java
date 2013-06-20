package linkedin;

/*
 if you have a linkedIn phone interview, mostly this question will be asked to you. 

 provide the simple solution first 
 while loop (b times) 
 { 
 result = result*a 
 } 


 Then note that it might be possible to divide this into smaller recursive problem. 
 we can use the property that a^b = (a^2)^(b/2) 
 here we square a, and divide b by 2. In doing this we divide the problem space into half. 

 so essentially, 

 when b i s even 
 pow(a,b) = pow(a^2, b/2); 
 when b is odd 
 pow(a, b) = a*pow(a^2, b/2); 
 */
public class Power {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int pow = 3;
		int val = 6;
		System.out.println(pow(val, pow));
		System.out.println(pow2(val, pow));
		System.out.println(pow2Iter(val, pow));
		// System.out.println(fastPower(3, 3));
		// System.out.println(fastPower2(3, 3));
	}

	public static double pow(double a, int b) {

		if (b == 0)
			return 1;
		if (b == 1)
			return a;
		double result = pow(a, b / 2);
		result = result * result;
		return ((b % 2 == 0) ? result : result * a);
	}

	public static double pow2(double a, int b) {

		if (b == 0)
			return 1;
		if (b == 1)
			return a;
		double result;
		if (b % 2 == 0) {
			result = pow2(Math.pow(a, 2), b / 2);
		} else {
			result = a * pow2(Math.pow(a, 2), b / 2);
		}
		return result;
	}

	public static double pow2Iter(double a, int b) {

		if (b == 0)
			return 1;
		if (b == 1)
			return a;

		double result = a;
		while (b > 1) {
			result *= result;
			if (b % 2 != 0) {
				result *= a;
			}
			b /= 2;
		}

		return result;
	}

	public static double fastPower(double a, int b) {

		double halfExp = b / 2;
		double power = 1;
		int i = 0;
		while (i < halfExp) {
			i++;
			power = power * a;
		}
		System.out.println(power);
		power = power * power;
		if (b % 2 > 0) {
			power = power * a;
		}
		return power;
	}

	public static int fastPower2(int n, int exp) {

		int halfExp = exp / 2;
		int power = 1;
		for (int i = 0; i < halfExp; i++, power = power * n)
			;
		power = power * power;
		if (exp % 2 > 0) {
			power = power * n;
		}
		return power;
	}
}
