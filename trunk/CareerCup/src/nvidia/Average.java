package nvidia;

//out of int range 
public class Average {

	public static void main(String[] args) {

		int a = 5;
		int b = 5;
		int avg = (a / 2) + (b / 2) + ((a % 2 + b % 2) / 2);
		System.out.println(avg);

	}

}
